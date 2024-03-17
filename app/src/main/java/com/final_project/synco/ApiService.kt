package com.final_project.synco


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("user")
    fun getUser(): Call<List<User>>

    @POST("api/auth/register")
    fun register(@Body user: User): Call<User>

    @POST("api/auth/login")
    fun loginUser(@Body loginUser: LoginUser): Call<LoginResponse>

    //createProject
    @POST("api/projects/insert")
    fun createProject(@Body projectData: ProjectData): Call<ProjectData>

    @GET("api/project/{id}")
    fun getProject(@Path("id") projectId: String): Call<ProjectData>
}