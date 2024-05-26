package dz.anpt.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import dz.anpt.movies.Model.Movie

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val imagePoster = findViewById<ImageView>(R.id.imageView_a2)
        val titleMovie = findViewById<TextView>(R.id.txt_a2_title_movie)
        val dateMovie = findViewById<TextView>(R.id.txt_a2_date_movie)
        val overviewMovie = findViewById<TextView>(R.id.txt_a2_overview)

        val movie = intent.getSerializableExtra("MOVIE") as? Movie
        titleMovie.text = movie?.originalTitle.toString()
        dateMovie.text = movie?.releaseDate.toString()
        overviewMovie.text = movie?.overview.toString()

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500" + movie?.backdropPath)
            .into(imagePoster)

    }
}