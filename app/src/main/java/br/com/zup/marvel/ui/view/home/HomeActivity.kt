package br.com.zup.marvel.ui.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.marvel.*
import br.com.zup.marvel.ui.view.home.adapter.MarvelAdapter
import br.com.zup.marvel.databinding.ActivityHomeBinding
import br.com.zup.marvel.ui.viewmodel.bio.DetailActivity
import br.com.zup.marvel.ui.viewmodel.info.InfoActivity
import br.com.zup.marvel.domain.model.Character

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val adapter: MarvelAdapter by lazy {
        MarvelAdapter(arrayListOf(), this::detailActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        heroesRecyclerView()

        binding.bvMarvelInfo.setOnClickListener {
            startActivity(Intent(this, InfoActivity::class.java))
        }
    }

    private fun heroesRecyclerView() {
        addItemToHeroesList()
        binding.rvHeroes.adapter = adapter
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
    }

    private fun addItemToHeroesList() {
        val heroesList = mutableListOf<Character>()

        heroesList.add(
            Character(
                R.drawable.gamora,
                GAMORRA_NAME,
                GAMORRA_BIO
            )
        )

        heroesList.add(
            Character(
                R.drawable.homem_ferro,
                IRONMAN_NAME,
                IRONMAN_BIO
            )
        )

        heroesList.add(
            Character(
                R.drawable.mulher_invisivel,
                INVISIBLE_WOMAN_NAME,
                INVISIBLE_WOMAN_BIO
            )
        )
        adapter.updateHeroList(heroesList)
    }

    private fun detailActivity(hero: Character) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(MARVEL_KEY, hero)
        }
        startActivity(intent)
    }
}