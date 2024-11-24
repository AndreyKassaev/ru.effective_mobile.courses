package ru.effective_mobile.courses.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import ru.effective_mobile.courses.data.entity.Course

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: Course)

    @Query("SELECT * FROM course WHERE courseId = :id")
    fun getCourseById(id: String): Flow<Course>

    @Query("SELECT * FROM course AS course")
    fun getAllCourses(): Flow<List<Course>>

    @Update
    suspend fun updateCourse(course: Course)

    @Transaction
    suspend fun toggleFavorite(courseId: String) {
        println("DAO: $courseId")
        getCourseById(courseId).first().let { course ->
            updateCourse(
                course.copy(
                    isFavorite = !course.isFavorite
                )
            )
            println(
                course.isFavorite
            )
        }
    }

    @Query("SELECT * FROM course WHERE isFavorite is 1")
    fun getFavoriteCourseList(): Flow<List<Course>>

}