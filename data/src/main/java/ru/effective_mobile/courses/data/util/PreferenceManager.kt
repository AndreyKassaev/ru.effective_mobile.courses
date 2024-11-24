package ru.effective_mobile.courses.data.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(
    context: Context
) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)

    fun incrementPage() {
        sharedPreferences.edit().putInt("page", (getPage() + 1)).apply()
    }

    fun savePage(value: Int) {
        sharedPreferences.edit().putInt("page", value).apply()
    }

    fun getPage(defaultValue: Int = 1): Int {
        return sharedPreferences.getInt("page", defaultValue)
    }


    fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}