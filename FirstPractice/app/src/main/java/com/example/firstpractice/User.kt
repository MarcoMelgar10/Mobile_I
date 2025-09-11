package com.example.firstpractice

import java.io.Serializable

class User(
   var id: String,
   var username: String,
   var post: Post,
   var mail: String,
   var perfilPicture: String,
): Serializable {
}