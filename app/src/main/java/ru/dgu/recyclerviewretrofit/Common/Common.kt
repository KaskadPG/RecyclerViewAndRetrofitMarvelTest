package ru.dgu.recyclerviewretrofit.Common

import ru.dgu.recyclerviewretrofit.Retrofit.RetrofitClient
import ru.dgu.recyclerviewretrofit.Interface.RetrofitServieces


object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitService: RetrofitServieces
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServieces::class.java)
}