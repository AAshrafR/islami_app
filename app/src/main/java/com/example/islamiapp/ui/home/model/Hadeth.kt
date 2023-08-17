package com.example.islamiapp.ui.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Hadeth(val title: String, val content: String) : Parcelable