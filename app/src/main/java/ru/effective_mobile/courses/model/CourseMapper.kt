package ru.effective_mobile.courses.model

import ru.effective_mobile.courses.domain.model.Course as DomainCourse
import ru.effective_mobile.courses.domain.model.CourseVendor as DomainCourseVendor
import ru.effective_mobile.courses.model.Course as AppCourse
import ru.effective_mobile.courses.model.CourseVendor as AppCourseVendor

internal object CourseMapper {

    fun mapToAppCourseVendor(domainCourseVendor: DomainCourseVendor): AppCourseVendor =
        AppCourseVendor(
            name = domainCourseVendor.name,
            imageUrl = domainCourseVendor.imageUrl
        )

    fun mapToDomainCourseVendor(appCourseVendor: AppCourseVendor): DomainCourseVendor =
        DomainCourseVendor(
            name = appCourseVendor.name,
            imageUrl = appCourseVendor.imageUrl
        )

    fun mapToAppCourse(domainCourse: DomainCourse): AppCourse =
        AppCourse(
            courseId = domainCourse.courseId,
            title = domainCourse.title,
            desc = domainCourse.desc,
            ads = domainCourse.ads,
            imageUrl = domainCourse.imageUrl,
            price = domainCourse.price,
            rate = domainCourse.rate,
            date = domainCourse.date,
            isFavorite = domainCourse.isFavorite,
            vendor = mapToAppCourseVendor(domainCourse.vendor),
            canonicalUrl = domainCourse.canonicalUrl
        )

    fun mapToDomainCourse(appCourse: AppCourse): DomainCourse =
        DomainCourse(
            courseId = appCourse.courseId,
            title = appCourse.title,
            desc = appCourse.desc,
            ads = appCourse.ads,
            imageUrl = appCourse.imageUrl,
            price = appCourse.price,
            rate = appCourse.rate,
            date = appCourse.date,
            isFavorite = appCourse.isFavorite,
            vendor = mapToDomainCourseVendor(appCourse.vendor),
            canonicalUrl = appCourse.canonicalUrl
        )

    fun mapToAppCourseList(domainCourses: List<DomainCourse>): List<AppCourse> =
        domainCourses.map { mapToAppCourse(it) }

    fun mapToDomainCourseList(appCourses: List<AppCourse>): List<DomainCourse> =
        appCourses.map { mapToDomainCourse(it) }
}