package com.app.lontara.bignews.API_Service

import com.example.newstoday.API_Service.Api_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService{

    @GET("top-headlines")
    suspend fun getAllNews(
        @Query("country") country : String? = "us",
        @Query("sortBy") sortBy : String = "publishedAt",
        @Query("category") category : String?,
        @Query("apiKey") apiKey : String = Api_KEY

    ) : Response<NewsModel>

    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = Api_KEY
    ): Response<NewsModel>



}

