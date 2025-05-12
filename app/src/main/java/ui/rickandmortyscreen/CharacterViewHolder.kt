package ui.rickandmortyscreen

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cinncinatiai.albumtableview.databinding.CardViewDesignBinding
import com.cinncinatiai.albumtableview.model.CharacterModel

class CharacterViewHolder(val item: CardViewDesignBinding) : RecyclerView.ViewHolder(item.root) {

    fun bindItem(character: CharacterModel) {
        item.textView.text = character.name
        item.textSpecie.text = character.species
        //todo remaining labels
        Glide.with(item.root.context).load(character.image).into(item.imageview)
    }
}