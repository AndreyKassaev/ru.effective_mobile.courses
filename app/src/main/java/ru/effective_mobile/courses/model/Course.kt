package ru.effective_mobile.courses.model

data class Course(
    val title: String,
    val textBody: String,
    val imageUrl: String,
    val price: String,
    val rate: String,
    val date: String,
    val isFavorite: Boolean
) {
    companion object {
        val mock = Course(
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