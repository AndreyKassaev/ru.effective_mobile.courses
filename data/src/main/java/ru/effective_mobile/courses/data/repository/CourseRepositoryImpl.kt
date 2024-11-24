package ru.effective_mobile.courses.data.repository


import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import ru.effective_mobile.courses.data.api.ApiService
import ru.effective_mobile.courses.data.db.CourseDao
import ru.effective_mobile.courses.data.model.CourseMapper.mapToCourseEntity
import ru.effective_mobile.courses.data.model.CourseMapper.mapToDomainCourse
import ru.effective_mobile.courses.data.model.CourseMapper.mapApiResponseListToDomainCourseList
import ru.effective_mobile.courses.data.model.CourseMapper.mapDbEntityListToDomainCourseList
import ru.effective_mobile.courses.data.response.CourseList
import ru.effective_mobile.courses.data.response.CourseRate
import ru.effective_mobile.courses.data.util.PreferenceManager
import ru.effective_mobile.courses.domain.model.Course
import ru.effective_mobile.courses.domain.repository.CourseRepository
import ru.effective_mobile.courses.data.model.Course as DataCourse
import ru.effective_mobile.courses.domain.model.Course as DomainCourse

class CourseRepositoryImpl(
    private val apiService: ApiService,
    private val courseDao: CourseDao,
    private val preferenceManager: PreferenceManager
) : CourseRepository {

    private val json = Json { ignoreUnknownKeys = true }

    override suspend fun getAllAvailableCourseList() {
        try {
            getCourseListWithoutRate()
                .also {
                    preferenceManager.incrementPage()
                }
                .also { courseListWithoutRate ->
                    getCourseListWithRate(courseListWithoutRate).also { courseListWithRate ->
                        insertCourseListWithRateIntoDatabase(courseListWithRate)
                    }
                }
        } catch (e: Exception) {
            getAllAvailableCourseList()
            e.printStackTrace()
        }
    }

    private suspend fun insertCourseListWithRateIntoDatabase(courseListWithRate: List<Course>) {
        coroutineScope {
            launch {
                courseListWithRate.forEach { course ->
                    try {
                        courseDao.insertCourse(
                            mapToCourseEntity(course)
                        )
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    private suspend fun getCourseListWithRate(courseListWithoutRate: List<Course>): List<Course> =
        coroutineScope {
            courseListWithoutRate.map { course ->
                async {
                    course.copy(
                        rate = getCourseRate(
                            courseId = course.courseId
                        )
                    )
                }
            }.awaitAll()
        }

    private suspend fun getCourseListWithoutRate(): List<Course> {
        val courseListWithoutRate = mapApiResponseListToDomainCourseList(
            json.decodeFromString<CourseList>(
                apiService
                    .getJsonStringAllCourseList(
                        currentPage = preferenceManager.getPage()
                    )
            ).courses
        )
        return courseListWithoutRate
    }

    override fun getAllAvailableCourseListFlow() =
        courseDao.getAllCourses().map {
            mapDbEntityListToDomainCourseList(
                it
            )
        }

    override suspend fun toggleFavorite(courseId: String) {
        courseDao.toggleFavorite(courseId = courseId)
    }


    override fun getAllFavoriteCourses(): Flow<List<DomainCourse>> =
        courseDao.getFavoriteCourseList().map {
            mapDbEntityListToDomainCourseList(
                it
            )
        }

    override fun getAllPersonalCourses(): Flow<List<DomainCourse>> =
        courseDao.getFavoriteCourseList().map {
            mapDbEntityListToDomainCourseList(
                it
            )
        }

    override fun getCourseDetail(courseId: String): Flow<DomainCourse> =
        courseDao.getCourseById(
            id = courseId
        ).map {
            mapToDomainCourse(it)
        }

    private suspend fun getCourseRate(courseId: String): String {
        val rate = json.decodeFromString<CourseRate>(
            apiService.getJsonStringCourseRate(
                courseId = courseId
            )
        ).courseReviewSummaries.first().average
        return String.format("%.1f", rate)
    }
}