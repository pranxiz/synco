package com.final_project.synco
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

interface RetrofitClient {
    companion object {
        private const val BASE_URL = "https://morning-tundra-19173-4a1d0b685181.herokuapp.com/"

        @RequiresApi(Build.VERSION_CODES.O)
        private fun createGson(): Gson {
            return GsonBuilder()
                // Register an adapter to manage LocalDate types
                .registerTypeAdapter(LocalDate::class.java, object : TypeAdapter<LocalDate>() {
                    @RequiresApi(Build.VERSION_CODES.O)
                    @Throws(IOException::class)
                    override fun write(out: JsonWriter, value: LocalDate?) {
                        if (value == null) {
                            out.nullValue()
                        } else {
                            out.value(value.format(DateTimeFormatter.ISO_LOCAL_DATE))
                        }
                    }

                    @RequiresApi(Build.VERSION_CODES.O)
                    @Throws(IOException::class)
                    override fun read(input: JsonReader): LocalDate? {
                        return if (input.peek() == com.google.gson.stream.JsonToken.NULL) {
                            input.nextNull()
                            null
                        } else {
                            LocalDate.parse(input.nextString(), DateTimeFormatter.ISO_LOCAL_DATE)
                        }
                    }
                })
                .create()
        }

        fun getService(): ApiService {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(createGson())) // Use custom Gson instance
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}