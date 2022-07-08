package br.com.zup.marvel.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity (tableName = "characters")
class Character(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "character_id")
    private var characterId: Int,
    private var characterName: String,
    private var thumbnail: Int,
    private var bio: String
) : Parcelable {
    fun getCharacterId() = this.characterId
    fun getCharacterThumb() = this.thumbnail
    fun getCharacterName() = this.characterName
    fun getCharacterBio() = this.bio
}