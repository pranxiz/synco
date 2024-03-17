package com.final_project.synco

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("name")
    val name: String?,

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String,

    )