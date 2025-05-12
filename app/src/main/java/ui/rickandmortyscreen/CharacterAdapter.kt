package ui.rickandmortyscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cinncinatiai.albumtableview.databinding.CardViewDesignBinding
import com.cinncinatiai.albumtableview.model.CharacterModel

class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {
    private val items = mutableListOf<CharacterModel>()

    fun setCharacter(characters: List<CharacterModel>) {
        items.clear()
        items.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        val view = CardViewDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

}