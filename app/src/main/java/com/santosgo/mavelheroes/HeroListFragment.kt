package com.santosgo.mavelheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.santosgo.mavelheroes.data.Datasource
import com.santosgo.mavelheroes.databinding.FragmentHeroListBinding


class HeroListFragment : Fragment() {

    private var _binding : FragmentHeroListBinding? = null
    val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHeroListBinding.inflate(inflater,container,false)

        val heroes = Datasource.getHeroList()


        //texto inicial
        binding.textView.text = getString(R.string.hero_list)
        //para la otra forma
        //binding.textView.text = getString(R.string.hero_list) + "\n\n"
        heroes.forEach {
            binding.textView.append("\nHeroe: ${it.name}")
            //otra forma
            //binding.textView.text =P binding.textView.toString() + "Heroe: ${hero.name}\n"
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}