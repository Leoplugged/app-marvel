package br.com.zup.marvel.ui.view.Comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.marvel.databinding.FragmentComicsBinding

class ComicsFragment : Fragment() {
    private lateinit var binding: FragmentComicsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }
}