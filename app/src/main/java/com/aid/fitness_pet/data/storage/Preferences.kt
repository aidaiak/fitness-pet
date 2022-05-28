package com.aid.fitness_pet.data.storage

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(@ApplicationContext context: Context) {

    private val preference: SharedPreferences by lazy {
        context.getSharedPreferences("fitness", Context.MODE_PRIVATE)
    }

    var phoneNumber: String?
        get() = preference.getString("phone_number", "")
        set(value) {
            preference.edit().putString("phone_number", value).apply()
        }

    fun containsPhoneNumber(): Boolean {
        return preference.contains("phone_number")
    }
}