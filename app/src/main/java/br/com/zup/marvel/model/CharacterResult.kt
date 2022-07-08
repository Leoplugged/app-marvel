package br.com.zup.marvel.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Characters")
data class CharacterResult(
    @SerializedName("id")
    @PrimaryKey (autoGenerate = false)
    val id: Int = 0,
    @SerializedName("bio")
    val description: String = "",
    @SerializedName("modified")
    val modified: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("resource_uri")
    val resourceURI: String = "",
    val thumbnail: Int = 0,
    @SerializedName("series")
    val series: List<Series> = listOf(),
    @SerializedName("urls")
    val urls: List<Url> = listOf(),
    @SerializedName("comics")
    val comics: List<Comics> = listOf(),
    @SerializedName("stories")
    val stories: List<Stories> = listOf(),
    @SerializedName("events")
    val events: List<Events> = listOf(),
    var isFavorite: Boolean
): Parcelable