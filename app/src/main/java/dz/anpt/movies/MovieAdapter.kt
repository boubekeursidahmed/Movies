package dz.anpt.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dz.anpt.movies.Model.Movie

class MovieAdapter (): RecyclerView.Adapter<MovieAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val titleMovie: TextView = view.findViewById(R.id.title_in_list)
        val voteMovie: TextView = view.findViewById(R.id.vote_in_list)
        val imageMovie : ImageView = view.findViewById(R.id.imageView)

        val btn: Button = view.findViewById(R.id.button)
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
        //holder.imageMovie.setImageResource(movie.posterPath)
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .into(holder.imageMovie)

        //holder.btn.setOnClickListener {
        //    val intent = Intent(context, MainActivity2::class.java)
        //    intent.putExtra("movie_title",movie.originalTitle)
        //    context.startActivity(intent)
        //}
    }

    override fun getItemCount(): Int = movies.size

}