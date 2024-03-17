package com.final_project.synco

import com.google.gson.annotations.SerializedName

data class ProjectData(
    @SerializedName("class_name")
    val class_name: String?,

    @SerializedName("project_date")
    val project_date: String,

    @SerializedName("submission_date")
    val submission_date: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("created_by")
    val created_by: Long


)

data class GetProjectData(
    @SerializedName("id")
    val id: Int
)



