package com.example.gifviewer.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gifviewer.Model.Data
import com.example.gifviewer.R
import com.example.gifviewer.fragment.FullGifFragment
import kotlinx.android.synthetic.main.layout_gif_item.view.*

class MyGifsAdapter(private val context: Context, private val gifsList: List<Data>): RecyclerView.Adapter<MyGifsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_gif_item, parent, false)
        val myHolder = MyViewHolder(itemView)
        return myHolder
    }

    override fun getItemCount(): Int {
        return gifsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.itemView).load(gifsList[position].images.original.url).into(holder.image)
        holder.txt_name.text = gifsList[position].title
        holder.txt_author.text = gifsList[position].username
        holder.txt_date.text = gifsList[position].import_datetime
        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                    val activity = v!!.context as AppCompatActivity
                    val fullGifFragment = FullGifFragment.newInstance(gifsList[position].images.original.url)
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.rec, fullGifFragment).addToBackStack(null)
                        .commit()
        }

        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView
        var txt_name : TextView
        var txt_author : TextView
        var txt_date : TextView
        lateinit var context:Context

        init {
            image = itemView.gif
            txt_name = itemView.txt_name
            txt_author = itemView.txt_author
            txt_date = itemView.txt_date
        }
    }
}