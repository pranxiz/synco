package com.final_project.synco

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class ProjectData(
    @SerializedName("class_name")
    val class_name: String?,

    @SerializedName("project_date")
    val project_date: LocalDate,

    @SerializedName("submission_date")
    val submission_date: LocalDate,

    @SerializedName("description")
    val description: String,

    @SerializedName("created_by")
    val created_by: Long
)