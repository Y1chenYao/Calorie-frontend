package com.example.hackchallenge

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val title=findViewById<TextView>(R.id.title)
        val calory=findViewById<TextView>(R.id.calory)
        val image=findViewById<ImageView>(R.id.imageView)
        val content=findViewById<TextView>(R.id.content)
        val button=findViewById<Button>(R.id.button2)
        val name:String= intent.getStringExtra("foodtitle") as String
        val des:String= intent.getStringExtra("fooddescription") as String
        val cal:Int=intent.getIntExtra("calory",0)
        title.text=name
        //val bmp = BitmapFactory.decodeByteArray(image, 0, image!!.size)
        //foodimage.setImageBitmap(bmp);    }
        content.text=des
        calory.text="Calories: "+cal.toString()
        button.setOnClickListener{
            finish()
        }
        }



}