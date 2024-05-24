package dz.anpt.movies.network

import dz.anpt.movies.Model.ResponseMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    fun getMovies(@Query("api_key") apiKey: String): Call<ResponseMovie>

    //@GET("movie/653346?api_key=c9856d0cb57c3f14bf75bdc6c063b8f3")
    //fun getMovie(): Call<Movie>
}