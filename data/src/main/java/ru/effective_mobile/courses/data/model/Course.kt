package ru.effective_mobile.courses.data.model

sealed class DisplayableItem

data class Course(
    val courseId: String,
    val title: String,
    val desc: String,
    val ads: String,
    val imageUrl: String,
    val price: String,
    val rate: String,
    val date: String,
    val isFavorite: Boolean,
    val vendor: CourseVendor
) : DisplayableItem() {
    companion object {
        val mock = Course(
            courseId = "courseId",
            title = "title",
            desc = "desc",
            ads = "ads",
            imageUrl = "https://kassaev.com/media/android_14.png",
            price = "price",
            rate = "rate",
            date = "date",
            isFavorite = true,
            vendor = CourseVendor.mock
        )
    }
}