package com.example.gifviewer.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.gifviewer.R
import kotlinx.android.synthetic.main.fragment_full_gif.*

/**
 * A simple [Fragment] subclass.
 */
class FullGifFragment : Fragment() {

    private var urlGif = ""
    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString("URL Gif")?.let {
            urlGif = it
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
  //      Glide.with(this).load(urlGif).into(fullGif)
        return inflater.inflate(R.layout.fragment_full_gif,container,false)
    }

    companion object {

        @JvmStatic
        fun newInstance(urlGif: String) = FullGifFragment().apply {
            arguments = Bundle().apply {
                putString("URL Gif", urlGif)
            }
        }
    }
}
