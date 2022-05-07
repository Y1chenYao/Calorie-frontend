package com.example.hackchallenge


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class FoodAdapter(val mDataset: ArrayList<Food>, val callbackInterface: CallbackInterface):
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    interface CallbackInterface {
        fun onClick(song: Food, position: Int)
    }

    class ViewHolder(view: View, callbackInterface: CallbackInterface):RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.foodimage)
        val name:TextView = view.findViewById(R.id.foodname)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.footcard,parent,false)
        return ViewHolder(view, callbackInterface)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = mDataset[position].name
        holder.image.setOnClickListener { callbackInterface.onClick(mDataset[position],position) }
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }
    }

