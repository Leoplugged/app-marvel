package br.com.zup.marvel.ui.viewmodel.info

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    //TODO criar o PagerAdapater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showAppBarCustom()
        //showViewPagerTabLayout()
    }

    private fun showAppBarCustom() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.company_name)
    }

    private fun showViewPagerTabLayout() {
        //TODO implementar a exibição do viewPager e do TabLayout
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}