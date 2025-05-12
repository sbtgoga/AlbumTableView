package ui.albumsscreen

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cinncinatiai.albumtableview.databinding.CardViewDesignBinding
import com.cinncinatiai.albumtableview.model.AlbumModel

class AlbumViewHolder(val item: CardViewDesignBinding) : RecyclerView.ViewHolder(item.root) {

    fun bindItem(album: AlbumModel) {
        item.textView.text = album.title
        Glide.with(item.root.context).load(album.thumbnailURL).into(item.imageview)
    }
}