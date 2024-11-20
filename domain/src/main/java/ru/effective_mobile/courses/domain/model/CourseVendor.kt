package ru.effective_mobile.courses.domain.model

data class CourseVendor(
    val name: String,
    val imageUrl: String
) {
    companion object {
        val mock = CourseVendor(
            name = "CourseVendor",
            imageUrl = "https://kassaev.com/media/android_11.png"
        )
    }
}
