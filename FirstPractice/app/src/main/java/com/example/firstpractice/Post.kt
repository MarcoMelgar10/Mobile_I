package com.example.firstpractice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Post(
    var id: String,
    var status: Boolean,
    likes: Int,
    var images: List<String>,
   var usersLiked: MutableList<String>,
) {
    var likes by mutableStateOf(likes)

}