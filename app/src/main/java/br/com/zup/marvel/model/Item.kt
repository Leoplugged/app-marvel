package br.com.zup.marvel.model

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "item")
data class Item(
    @SerializedName("available_series")
    val name: String,
    @SerializedName("available_series")
    val resourceURI: String
) : Parcelable