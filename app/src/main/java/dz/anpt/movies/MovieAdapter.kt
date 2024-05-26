package dz.anpt.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dz.anpt.movies.Model.Movie

class MovieAdapter (private val context: Context): RecyclerView.Adapter<MovieAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val titleMovie: TextView = view.findViewById(R.id.title_in_list)
        val voteMovie: TextView = view.findViewById(R.id.vote_in_list)
        val imageMovie : ImageView = view.findViewById(R.id.imageView)
    }

    private var movies: List<Movie> = listOf()

    fun setMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleMovie.text = movie.originalTitle.toString()
        holder.voteMovie.text = movie.voteCount.toString()

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .into(holder.imageMovie)


        holder.itemView.setOnClickListener {
            val intent = Intent(context, MovieDetailActivity::class.java)

            intent.putExtra("MOVIE", movie)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = movies.size

}