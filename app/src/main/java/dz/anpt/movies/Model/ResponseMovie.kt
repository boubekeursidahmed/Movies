package dz.anpt.movies.Model

import com.google.gson.annotations.SerializedName

data class ResponseMovie(
    @SerializedName("results")
    var results: List<Movie>
)
