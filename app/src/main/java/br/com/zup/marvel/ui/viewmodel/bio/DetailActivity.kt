package br.com.zup.marvel.ui.viewmodel.bio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.marvel.MARVEL_KEY
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.ActivityBioBinding
import br.com.zup.marvel.domain.model.Character

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.title_biography)

        getMarvel()
    }

    private fun getMarvel(){
        val heroHero = intent.getParcelableExtra<Character>(MARVEL_KEY)

        if (heroHero != null){
            getInfo(heroHero)
        }
    }

    private fun getInfo(hero: Character){
        binding.ivHeroBio.setImageResource(hero.getImage())
        binding.tvHeroName.text = hero.getHeroName()
        binding.tvHeroBio.text = hero.getHeroBio()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}