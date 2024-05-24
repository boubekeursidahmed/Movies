package dz.anpt.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dz.anpt.movies.Model.ResponseMovie
import dz.anpt.movies.network.ApiService
import dz.anpt.movies.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val movieAdapter : MovieAdapter = MovieAdapter()
        recyclerView.adapter = movieAdapter

        recyclerView.setHasFixedSize(true)

        val apiService = RetrofitInstance.retrofit.create(ApiService::class.java)

        apiService.getMovies(RetrofitInstance.API_KEY).enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(call: Call<ResponseMovie>, response: Response<ResponseMovie>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        movieAdapter.setMovies(it.results)
                        //Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Erreur serveur", Toast.LENGTH_LONG).show()
            }
        })
        }
    }
