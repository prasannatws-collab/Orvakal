package com.orvakal.app.data.remote.api

import com.orvakal.app.data.remote.dto.ServiceDto
import retrofit2.http.GET
import retrofit2.http.Path

interface OrvikalApiService {

    @GET("services")
    suspend fun getServices(): List<ServiceDto>

    @GET("services/{id}")
    suspend fun getServiceById(@Path("id") id: Int): ServiceDto
}
