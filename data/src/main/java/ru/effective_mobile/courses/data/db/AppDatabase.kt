package ru.effective_mobile.courses.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.effective_mobile.courses.data.entity.Course

@Database(
    entities = [
        Course::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}