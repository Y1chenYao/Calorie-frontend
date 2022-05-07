package com.example.hackchallenge

import android.graphics.drawable.Drawable
import java.io.Serializable
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Food(
                var name: String,
                var description: String,
                var calories: Int
): Serializable
