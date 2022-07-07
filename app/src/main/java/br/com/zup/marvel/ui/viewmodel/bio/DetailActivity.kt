package br.com.zup.marvel.ui.viewmodel.bio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.marvel.MARVEL_KEY
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.ActivityBioBinding
import br.com.zup.marvel.domain.model.Marvel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.detail_name)

        getMarvel()
    }

    private fun getMarvel(){
        val marvelHero = intent.getParcelableExtra<Marvel>(MARVEL_KEY)

        if (marvelHero != null){
            getInfo(marvelHero)
        }
    }

    private fun getInfo(marvel: Marvel){
        binding.ivHeroBio.setImageResource(marvel.getImage())
        binding.tvHeroName.text = marvel.getHeroName()
        binding.tvHeroBio.text = marvel.getHeroBio()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}