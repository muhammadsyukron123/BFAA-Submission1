package com.syukron.githubusersubmission

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val username: String,
    val name: String,
    val location: String,
    val company: String,
    val repository: String,
    val followers: String,
    val following: String,
    val avatar: Int

): Parcelable