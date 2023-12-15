package com.santosgo.mavelheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.santosgo.mavelheroes.databinding.FragmentHeroListBinding


class HeroListFragment : Fragment() {

    private var _binding: FragmentHeroListBinding? = null
    val binding
        get() = _binding!!

    val heroes = Datasource.getHeroList()

    private lateinit var heroAdapter: HeroAdapter

    private lateinit var layoutManager: LayoutManager
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
        _binding = FragmentHeroListBinding.inflate(inflater, container, false)
        initRecView()
        binding.textView.isVisible = false

        return binding.root
    }

    private fun initRecView() {
        heroAdapter = HeroAdapter(heroes, {pos -> deleteHero(pos)})
        binding.rvHeroes.adapter = heroAdapter

        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvHeroes.layoutManager = layoutManager
    }


    fun deleteHero(pos : Int){
        heroes.removeAt(pos)
        binding.rvHeroes.adapter?.notifyItemRemoved(pos)
    }

    //texto inicial
//        binding.textView.text = getString(R.string.hero_list)
    //para la otra forma
    //binding.textView.text = getString(R.string.hero_list) + "\n\n"
//        heroes.forEach {
//            binding.textView.append("\nHeroe: ${it.name}")
    //otra forma
    //binding.textView.text =P binding.textView.toString() + "Heroe: ${hero.name}\n"
//        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}