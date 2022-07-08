package br.com.zup.marvel.model

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
) : Parcelable