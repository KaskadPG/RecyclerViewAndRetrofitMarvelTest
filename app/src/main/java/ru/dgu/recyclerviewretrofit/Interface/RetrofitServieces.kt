package ru.dgu.recyclerviewretrofit.Interface

import retrofit2.Call
import retrofit2.http.GET
import ru.dgu.recyclerviewretrofit.Model.Movie

interface RetrofitServieces {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}