package ru.effective_mobile.courses.recycle_view

data class CourseCardModel(
    val title: String,
    val textBody: String,
    val imageUrl: String,
    val price: String,
    val rate: String,
    val date: String,
    val isFavorite: Boolean
) {
    companion object {
        val mock = CourseCardModel(
            title = "title",
            textBody = "textBody",
            imageUrl = "https://kassaev.com/media/android_14.png",
            price = "price",
            rate = "rate",
            date = "date",
            isFavorite = true
        )
    }
}