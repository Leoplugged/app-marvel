package br.com.zup.marvel.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
): Parcelable