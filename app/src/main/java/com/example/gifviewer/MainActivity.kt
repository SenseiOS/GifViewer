package com.example.gifviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gifviewer.Interface.RetrofitService
import com.example.gifviewer.Adapter.MyGifsAdapter
import com.example.gifviewer.Common.Common
import com.example.gifviewer.Model.Data
import com.example.gifviewer.Model.Gifs
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : MyGifsAdapter
    //lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService

        recyclerGifsList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerGifsList.layoutManager = layoutManager

       // dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllGifList()
    }

    private fun getAllGifList() {
        //dialog.show()

        mService.getGifList().enqueue(object : Callback<Gifs> {
            override fun onFailure(call: Call<Gifs>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Gifs>, response: Response<Gifs>) {
                adapter = MyGifsAdapter(baseContext, (response.body() as Gifs).data)
                adapter.notifyDataSetChanged()
                recyclerGifsList.adapter = adapter
            }

        })
    }
}
