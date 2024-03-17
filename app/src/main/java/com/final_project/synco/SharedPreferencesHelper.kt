package com.final_project.synco

import android.content.Context

object SharedPreferencesHelper {
    private const val PREF_FILE_NAME = "MyAppPreferences"
    private const val KEY_USER_ID = "userId"
    private const val KEY_AUTH_TOKEN = "authToken"

    fun saveUserId(context: Context, userId: Long) {
        val sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putLong(KEY_USER_ID, userId)
        editor.apply()
    }

    fun getUserId(context: Context): Long {
        val sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getLong(KEY_USER_ID, -1L) // Return -1 if key not found
    }

    fun saveAuthToken(context: Context, authToken: String) {
        val sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(KEY_AUTH_TOKEN, authToken)
        editor.apply()
    }

    fun getAuthToken(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(KEY_AUTH_TOKEN, null)
    }


}
