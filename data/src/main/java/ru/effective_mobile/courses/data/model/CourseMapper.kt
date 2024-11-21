package ru.effective_mobile.courses.data.model

import ru.effective_mobile.courses.data.model.Course as DataCourse
import ru.effective_mobile.courses.data.model.CourseVendor as DataCourseVendor
import ru.effective_mobile.courses.domain.model.Course as DomainCourse
import ru.effective_mobile.courses.domain.model.CourseVendor as DomainCourseVendor

object CourseMapper {

    fun mapToDataCourseVendor(domainCourseVendor: DomainCourseVendor): DataCourseVendor =
        DataCourseVendor(
            name = domainCourseVendor.name,
            imageUrl = domainCourseVendor.imageUrl
        )

    fun mapToDomainCourseVendor(dataCourseVendor: DataCourseVendor): DomainCourseVendor =
        DomainCourseVendor(
            name = dataCourseVendor.name,
            imageUrl = dataCourseVendor.imageUrl
        )

    fun mapToDataCourse(domainCourse: DomainCourse): DataCourse =
        DataCourse(
            courseId = domainCourse.courseId,
            title = domainCourse.title,
            desc = domainCourse.desc,
            ads = domainCourse.ads,
            imageUrl = domainCourse.imageUrl,
            price = domainCourse.price,
            rate = domainCourse.rate,
            date = domainCourse.date,
            isFavorite = domainCourse.isFavorite,
            vendor = mapToDataCourseVendor(domainCourse.vendor)
        )

    fun mapToDomainCourse(dataCourse: DataCourse): DomainCourse =
        DomainCourse(
            courseId = dataCourse.courseId,
            title = dataCourse.title,
            desc = dataCourse.desc,
            ads = dataCourse.ads,
            imageUrl = dataCourse.imageUrl,
            price = dataCourse.price,
            rate = dataCourse.rate,
            date = dataCourse.date,
            isFavorite = dataCourse.isFavorite,
            vendor = mapToDomainCourseVendor(dataCourse.vendor)
        )

    fun mapToDataCourseList(domainCourses: List<DomainCourse>): List<DataCourse> =
        domainCourses.map { mapToDataCourse(it) }

    fun mapToDomainCourseList(dataCourses: List<DataCourse>): List<DomainCourse> =
        dataCourses.map { mapToDomainCourse(it) }
}