package com.santosgo.mavelheroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.santosgo.mavelheroes.databinding.HeroItemBinding

class HeroAdapter(
    private val heroList: MutableList<Hero>,
    private val onClickDelete: (Int) -> Unit,
    private val onClickAdd : (Int) -> Unit
) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {
    class HeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        companion object {
            const val DRAWABLE = "drawable"
        }

        private val binding = HeroItemBinding.bind(view)
        fun bind(hero: Hero, onClickDelete: (Int) -> Unit, onClickAdd : (Int) -> Unit) {
            binding.tvName.text = hero.name
            binding.tvPower.text = hero.power.toString()
            binding.tvIntelligence.text = hero.intelligence.toString()

            val context = itemView.context
            binding.ivPhoto.setImageResource(
                context.resources.getIdentifier(
                    hero.photo,
                    DRAWABLE,
                    context.packageName
                )
            )
            binding.root.setOnClickListener {
                Snackbar.make(it, "Has convocado a ${hero.name}!", Snackbar.LENGTH_SHORT).show()
                onClickAdd(adapterPosition)
            }

            //cuando se pinche sobre la "X" del héroe, se borrará
            binding.ivDelHero.setOnClickListener {
                Snackbar.make(it, "Has eliminado a ${hero.name}!", Snackbar.LENGTH_SHORT).show()
                onClickDelete(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroViewHolder(layoutInflater.inflate(R.layout.hero_item, parent, false))
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(heroList.get(position), onClickDelete, onClickAdd)

    }

}