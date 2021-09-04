package ru.dgu.recyclerviewretrofit.Adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import ru.dgu.recyclerviewretrofit.Model.Movie
import ru.dgu.recyclerviewretrofit.R
import com.squareup.picasso.Picasso



class MyMovieAdapter(private val context: Context, private val movieList: MutableList<Movie>):RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imageMovie: ImageView = itemView.imageMovie
        var txtName: TextView = itemView.txtName
        var txtTeam: TextView = itemView.txtTeam
        var txtCreatedby: TextView = itemView.txtCreatedby


        fun bind(listItem: Movie) {
            imageMovie.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.imageMovie}", Toast.LENGTH_SHORT)
                    .show()
            }
            itemView.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.txtName.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList[position]
        holder.bind(listItem)

        Picasso.get().load(movieList[position].imageurl).into(holder.imageMovie)
        holder.txtName.text = movieList[position].name
        holder.txtTeam.text = movieList[position].team
        holder.txtCreatedby.text = movieList[position].createdby
    }

}