package ui.albumsscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cinncinatiai.albumtableview.databinding.CardViewDesignBinding
import com.cinncinatiai.albumtableview.model.AlbumModel

class AlbumAdapter : RecyclerView.Adapter<AlbumViewHolder>() {
    private val items = mutableListOf<AlbumModel>()

    fun setAlbums(albums: List<AlbumModel>) {
        items.clear()
        items.addAll(albums)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumViewHolder {
        val view = CardViewDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

}