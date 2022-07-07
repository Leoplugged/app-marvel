package br.com.zup.marvel.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Marvel(
    private var image: Int,
    private var heroName: String,
    private var heroBio: String
) : Parcelable {
    fun getImage() = this.image
    fun getHeroName() = this.heroName
    fun getHeroBio() = this.heroBio
}