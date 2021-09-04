package ru.dgu.recyclerviewretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dmax.dialog.SpotsDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.dgu.recyclerviewretrofit.Adapter.MyMovieAdapter
import ru.dgu.recyclerviewretrofit.Common.Common
import ru.dgu.recyclerviewretrofit.Interface.RetrofitServieces
import ru.dgu.recyclerviewretrofit.Model.Movie
import ru.dgu.recyclerviewretrofit.R
import kotlinx.android.synthetic.main.activity_main.*





class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServieces
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
            }

            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }
        })
    }
}