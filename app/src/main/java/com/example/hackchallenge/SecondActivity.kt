package com.example.hackchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class SecondActivity : AppCompatActivity() {
    private val BASE_URL: String="http://129.213.99.28:5002/"
    private val client = OkHttpClient()
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private val foodJsonAdapter = moshi.adapter(Food::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var setname=findViewById<EditText>(R.id.nameev)
        var setcalory=findViewById<EditText>(R.id.caloryet)
        var setdescription=findViewById<EditText>(R.id.desciption_edit)
        var submit=findViewById<Button>(R.id.change_button)
        submit.setOnClickListener{
            runBlocking {
                withContext(Dispatchers.IO) {
                    val food = Food(setname.text.toString(),setdescription.text.toString(),setcalory.text.toString().toInt())
                    Log.i("description123",food.description)
                    Log.i("name123",food.name)
                    Log.i("calory123",food.calories.toString())
                    // make networking request
                    uploadFood(food)
                }
            }

        }
    }
    private fun uploadFood(food: Food) {
        Log.d("description123",food.description)
        Log.d("name123",food.name)
        Log.d("calory123",food.calories.toString())
        val requestPost = Request.Builder().url(BASE_URL+ "foods/")
            .post(foodJsonAdapter.toJson(food).toRequestBody()).build()
        client.newCall(requestPost).execute().use {
            if(!it.isSuccessful){
                // Log.d("Err",it.toString())
            }
        }

    }

}