package com.example.faye

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Card(
    val artistName: String,
    val movieName: String,
    @DrawableRes val imageResourcedId: Int)
{
}