package br.com.zup.marvel.ui.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.marvel.databinding.MarvelItemBinding
import br.com.zup.marvel.domain.model.Character

class MarvelAdapter(
    private var charactersList: MutableList<Character>,
    private val characterOnClick: (character: Character) -> Unit
) : RecyclerView.Adapter<MarvelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MarvelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val marvelHero = charactersList[position]
        holder.addInfoView(marvelCharacter)
        holder.binding.cvItemLista.setOnClickListener {
            characterOnClick(marvelCharacter)
        }
    }

    override fun getItemCount() = charactersList.size

    fun updateCharactersList(newList: MutableList<Character>) {
        if (charactersList.size == 0) {
            charactersList = newList
        } else {
            charactersList.addAll(newList)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: MarvelItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun addInfoView(character: Character) {
            binding.ivCharacter.setImageResource(character.getCharacterThumb())
            binding.tvCharacterName.text = character.getCharacterName()
        }
    }
}