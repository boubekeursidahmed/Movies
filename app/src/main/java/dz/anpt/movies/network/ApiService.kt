package dz.anpt.movies.network

import dz.anpt.movies.Model.Movie
import dz.anpt.movies.Model.ResponseMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    fun getMovies(@Query("api_key") apiKey: String): Call<ResponseMovie>

    @GET("movie/{movie_id}")
    fun getMovie(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String ): Call<Movie>

}