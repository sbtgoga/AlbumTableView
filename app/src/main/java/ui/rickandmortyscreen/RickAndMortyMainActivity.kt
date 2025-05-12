package ui.rickandmortyscreen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cinncinatiai.albumtableview.databinding.ActivityMainBinding
import utils.gone
import utils.show

class RickAndMortyMainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        MainViewModel()
    }
    private lateinit var binding: ActivityMainBinding
    private var characterAdapter: CharacterAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        characterAdapter = CharacterAdapter()
        binding.recyclerView.apply {
            this.layoutManager =
                LinearLayoutManager(this@RickAndMortyMainActivity, LinearLayoutManager.VERTICAL, false)
            this.adapter = characterAdapter
        }
        viewModel.onInit()
        viewModel.uiState.observe(this) { onUIState(it) }
    }

    private fun onUIState(uiState: MainUIState) {
        when (uiState) {
            MainUIState.Loading -> binding.progressBar.show()
            MainUIState.None -> {} //NOOP
            is MainUIState.CharacterLoaded -> {
                binding.progressBar.gone()
                characterAdapter?.setCharacter(uiState.characters)
            }

            is MainUIState.CharacterLoadError -> {
                binding.progressBar.gone()
                Toast.makeText(this, uiState.error, Toast.LENGTH_LONG).show()
            }
        }
    }
}