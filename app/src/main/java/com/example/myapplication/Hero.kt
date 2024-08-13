package com.example.myapplication

import android.os.Parcelable

import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val rating: String,
    val director: String,
    val writer:String,
    val photo: String
): Parcelable
