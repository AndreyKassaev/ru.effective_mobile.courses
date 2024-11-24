package ru.effective_mobile.courses.data.model

import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatterBuilder
import java.util.Locale
import ru.effective_mobile.courses.data.model.Course as DataCourse
import ru.effective_mobile.courses.data.model.CourseVendor as DataCourseVendor
import ru.effective_mobile.courses.data.response.Course as ResponseCourse
import ru.effective_mobile.courses.domain.model.Course as DomainCourse
import ru.effective_mobile.courses.domain.model.CourseVendor as DomainCourseVendor
import ru.effective_mobile.courses.data.entity.Course as CourseEntity

internal object CourseMapper {

    fun formatDateTimeToRu(dateTimeString: String?): String {
        return dateTimeString?.let {
            val dateTime = ZonedDateTime.parse(it)
            val outputFormatter = DateTimeFormatterBuilder()
                .appendPattern("dd MMMM yyyy")
                .toFormatter()
                .withLocale(Locale("ru"))
            dateTime.format(outputFormatter)
        } ?: ""
    }

    fun mapToCourseEntity(domainCourse: DomainCourse): CourseEntity =
        CourseEntity(
            courseId = domainCourse.courseId,
            title = domainCourse.title,
            ads = domainCourse.ads,
            desc = domainCourse.desc,
            imageUrl = domainCourse.imageUrl,
            price = domainCourse.price,
            rate = domainCourse.rate,
            date = domainCourse.date,
            isFavorite = domainCourse.isFavorite,
            canonicalUrl = domainCourse.canonicalUrl,
            vendorName = domainCourse.vendor.name,
            vendorImageUrl = domainCourse.vendor.imageUrl
        )

    fun mapToDomainCourse(courseEntity: CourseEntity): DomainCourse =
        DomainCourse(
            courseId = courseEntity.courseId,
            title = courseEntity.title,
            desc = courseEntity.desc,
            ads = courseEntity.ads,
            imageUrl = courseEntity.imageUrl,
            price = courseEntity.price,
            date = courseEntity.date,
            rate = courseEntity.rate,
            isFavorite = courseEntity.isFavorite,
            vendor = DomainCourseVendor(
                name = courseEntity.vendorName,
                imageUrl = courseEntity.vendorImageUrl
            ),
            canonicalUrl = courseEntity.canonicalUrl
        )


    fun mapToDomainCourse(responseCourse: ResponseCourse): DomainCourse =
        DomainCourse(
            courseId = responseCourse.id.toString(),
            title = responseCourse.title.toString(),
            desc = responseCourse.description.toString(),
            ads = responseCourse.summary.toString(),
            imageUrl = responseCourse.cover.toString(),
            price = responseCourse.price ?: "free",
            date = formatDateTimeToRu(responseCourse.createDate),
            rate = "rate",
            isFavorite = false,
            vendor = DomainCourseVendor(
                name = responseCourse.certificate.toString(),
                imageUrl = responseCourse.certificateCoverOrg.toString()
            ),
            canonicalUrl = responseCourse.canonicalUrl.toString()
        )

    fun mapToDomainCourseVendor(dataCourseVendor: DataCourseVendor): DomainCourseVendor =
        DomainCourseVendor(
            name = dataCourseVendor.name,
            imageUrl = dataCourseVendor.imageUrl
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
            vendor = mapToDomainCourseVendor(dataCourse.vendor),
            canonicalUrl = dataCourse.canonicalUrl
        )

    fun mapDbEntityListToDomainCourseList(courseEntityList: List<CourseEntity>): List<DomainCourse> =
        courseEntityList.map { mapToDomainCourse(it) }

    fun mapApiResponseListToDomainCourseList(responseCourse: List<ResponseCourse>): List<DomainCourse> =
        responseCourse.map { mapToDomainCourse(it) }

}