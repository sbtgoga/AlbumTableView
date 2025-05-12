package ui.albumsscreen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cinncinatiai.albumtableview.databinding.ActivityMainBinding
import utils.gone
import utils.show

class AlbumsActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        MainViewModel()
    }
    private lateinit var binding: ActivityMainBinding
    private var albumAdapter: AlbumAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        albumAdapter = AlbumAdapter()
        binding.recyclerView.apply {
            this.layoutManager =
                LinearLayoutManager(this@AlbumsActivity, LinearLayoutManager.VERTICAL, false)
            this.adapter = albumAdapter
        }
        //setContentView(R.layout.activity_main)

        viewModel.onInit()
        viewModel.uiState.observe(this) { onUIState(it) }
    }

    private fun onUIState(uiState: MainUIState) {
        when (uiState) {
            is MainUIState.AlbumLoaded -> {
                binding.progressBar.gone()
                albumAdapter?.setAlbums(uiState.albums)
            }

            MainUIState.Loading -> binding.progressBar.show()
            MainUIState.None -> {} //NOOP
            is MainUIState.AlbumLoadError -> {
                binding.progressBar.gone()

                Toast.makeText(this, uiState.error, Toast.LENGTH_LONG).show()
            }
        }
    }
}