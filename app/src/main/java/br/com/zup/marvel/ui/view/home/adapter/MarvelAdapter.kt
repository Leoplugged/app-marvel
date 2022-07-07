package br.com.zup.marvel.ui.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.marvel.databinding.MarvelItemBinding
import br.com.zup.marvel.domain.model.Marvel

class MarvelAdapter(
    private var heroesList: MutableList<Marvel>,
    private val heroOnClick: (hero: Marvel) -> Unit
) : RecyclerView.Adapter<MarvelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MarvelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val marvelHero = heroesList[position]
        holder.addInfoView(marvelHero)
        holder.binding.cvItemLista.setOnClickListener {
            heroOnClick(marvelHero)
        }
    }

    override fun getItemCount() = heroesList.size

    fun updateHeroList(newList: MutableList<Marvel>) {
        if (heroesList.size == 0) {
            heroesList = newList
        } else {
            heroesList.addAll(newList)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: MarvelItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun addInfoView(hero: Marvel) {
            binding.ivHero.setImageResource(hero.getImage())
            binding.tvNomeHeroi.text = hero.getHeroName()
        }
    }
}