package com.paging.lib.retrofit

import com.paging.lib.models.StackApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("answers")
    fun getAnswers(@Query("page") page: Int, @Query("pagesize") pagesize: Int, @Query("site") site: String): Call<StackApiResponse>
}
