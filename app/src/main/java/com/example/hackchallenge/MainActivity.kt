package com.example.hackchallenge

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() ,FoodAdapter.CallbackInterface{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview:RecyclerView=findViewById(R.id.my_recycler_view)
        recyclerview.setLayoutManager(GridLayoutManager(this, 2))
        var mDataSet=ArrayList<Food>()
        mDataSet.add(Food("Rice","One of the most popular grains in Asian.",206))
        mDataSet.add(Food("Rice","One of the most popular grains in Asian.",206))
        mDataSet.add(Food("Rice","One of the most popular grains in Asian.",206))
        mDataSet.add(Food("Rice","One of the most popular grains in Asian.",206))
        mDataSet.add(Food("Rice","One of the most popular grains in Asian.",206))
        mDataSet.add(Food("Rice","One of the most popular grains in Asian.",206))
        mDataSet.add(Food("Rice","One of the most popular grains in Asian.",206))
        mDataSet.add(Food("Rice","One of the most popular grains in Asian.",206))
        recyclerview.adapter=FoodAdapter(mDataSet,this)

        val fab:FloatingActionButton=findViewById(R.id.fab)
        fab.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(song: Food, position: Int) {
        val intent = Intent(this, ThirdActivity::class.java).apply {
            putExtra("foodtitle",song.name)
            putExtra("fooddescription",song.description)
            putExtra("calory",song.calories)
        }
        startActivity(intent)
    }
}