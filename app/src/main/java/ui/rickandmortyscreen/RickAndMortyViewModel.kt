package ui.rickandmortyscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinncinatiai.albumtableview.R
import com.cinncinatiai.albumtableview.model.CharacterModel
import com.cinncinatiai.albumtableview.repository.CharacterRepository
import com.cinncinatiai.albumtableview.repository.CharacterRepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel(private val characterRepo: CharacterRepository = CharacterRepositoryImpl()) :
    ViewModel() {

    private val _uiState = MutableLiveData<MainUIState>(MainUIState.None)
    val uiState: LiveData<MainUIState> = _uiState

    fun onInit() {
        _uiState.postValue(MainUIState.Loading)

        viewModelScope.launch {
            try {
                val characters = characterRepo.getCharacters()
                _uiState.postValue(MainUIState.CharacterLoaded(characters.results))
            } catch (err: Throwable) {
                err.printStackTrace()
                _uiState.postValue(MainUIState.CharacterLoadError(R.string.error_generic))
            }
        }
    }
}

sealed class MainUIState {
    data object None : MainUIState()
    data object Loading : MainUIState()
    data class CharacterLoaded(val characters: List<CharacterModel>) : MainUIState()
    data class CharacterLoadError(val error: Int) : MainUIState()

}