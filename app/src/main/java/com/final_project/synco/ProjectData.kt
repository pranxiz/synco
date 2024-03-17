package com.final_project.synco

import com.google.gson.annotations.SerializedName

data class ProjectData(
    @SerializedName("id")
    val id: Int,

    @SerializedName("class_name")
    val class_name: String?,

    @SerializedName("project_date")
    val project_date: String,

    @SerializedName("submission_date")
    val submission_date: String,

    @SerializedName("description")
    val description: String,


    )

data class Project(

    @SerializedName("class_name")
    val class_name: String?,

    @SerializedName("project_date")
    val project_date: String,

    @SerializedName("submission_date")
    val submission_date: String,

    @SerializedName("description")
    val description: String,


    )