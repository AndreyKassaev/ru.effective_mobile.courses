package ru.effective_mobile.courses.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "course"
)
data class Course(
    @PrimaryKey
    val courseId: String,
    val title: String,
    val desc: String,
    val ads: String,
    val imageUrl: String,
    val price: String,
    val rate: String,
    val date: String,
    val isFavorite: Boolean,
    val vendorName: String,
    val vendorImageUrl: String,
    val canonicalUrl: String
)