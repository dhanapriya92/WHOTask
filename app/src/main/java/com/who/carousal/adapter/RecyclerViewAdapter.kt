package com.who.carousal.adapter


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.who.carousal.R
import com.who.carousal.model.Attributes


public class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: ArrayList<Attributes>? = null
   var activity: Activity? = null
    val ITEM_TYPE_ONE = 0
    val ITEM_TYPE_TWO = 1

    fun RecyclerViewAdapter(data: ArrayList<Attributes>, act: Activity){
        this.data = data
        this.activity = act
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var v:View;
        if(viewType == 0) {
             v = inflater.inflate(R.layout.recycler_item_1, parent, false)
        }
        else
        {
             v = inflater.inflate(R.layout.recycler_item_2, parent, false)
        }
        return ViewHolder(v!!)
    }

    override fun getItemViewType(position: Int): Int {
        // based on you list you will return the ViewType
        return if (position == 0) {
            ITEM_TYPE_ONE
        } else {
            ITEM_TYPE_TWO
        }
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var tvName: TextView
//        var tvId: TextView
//        var tvSearchUrl: TextView
//        var tvNativeUrl: TextView
//        var tvIcon: ImageView
//
//        init {
//            tvName = itemView.findViewById(R.id.tvName)
//            tvIcon = itemView.findViewById(R.id.tvIcon)
//            tvId = itemView.findViewById(R.id.tvId)
//            tvSearchUrl = itemView.findViewById(R.id.tvSearchUrl)
//            tvNativeUrl = itemView.findViewById(R.id.tvNativeUrl)
//        }
    }

    class ButtonViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
//        var imgButton: ImageView
//
//        init {
//            imgButton = itemView.findViewById(R.id.imgButton)
//        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
         val itemType = getItemViewType(position);

    }

//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
}