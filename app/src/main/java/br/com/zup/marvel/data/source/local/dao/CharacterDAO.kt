package br.com.zup.marvel.data.source.local.dao

import androidx.room.*
import br.com.zup.marvel.model.CharacterResult


@Dao
interface CharacterDAO {
    @Query("SELECT * FROM characters ORDER BY name ASC")
    fun getAllCharacter(): List<CharacterResult>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCharacter(character: CharacterResult)

    @Query("SELECT * FROM characters WHERE isFavorite = 1")
    fun getAllFavCaracters(): List<CharacterResult>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllFavCharacters(listMovies: List<CharacterResult>)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateFavCharacter(character: CharacterResult)
}