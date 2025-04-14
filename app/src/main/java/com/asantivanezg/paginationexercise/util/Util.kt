package com.asantivanezg.paginationexercise.util

fun addBearer(token: String): String = "Bearer $token"

fun addBaseImageUrl(url: String) : String = "https://image.tmdb.org/t/p/w500$url"