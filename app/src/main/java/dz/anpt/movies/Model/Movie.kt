package dz.anpt.movies.Model

import com.google.gson.annotations.SerializedName
import java.util.*


data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: Date,
    @SerializedName("vote_count")
    val voteCount: Int,
)
