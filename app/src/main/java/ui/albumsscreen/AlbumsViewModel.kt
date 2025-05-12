package ui.albumsscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinncinatiai.albumtableview.R
import com.cinncinatiai.albumtableview.model.AlbumModel
import com.cinncinatiai.albumtableview.repository.AlbumRepository
import com.cinncinatiai.albumtableview.repository.AlbumRepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel(private val albumRepo: AlbumRepository = AlbumRepositoryImpl()) :
    ViewModel() {

    private val _uiState = MutableLiveData<MainUIState>(MainUIState.None)
    val uiState: LiveData<MainUIState> = _uiState

    fun onInit() {
        _uiState.postValue(MainUIState.Loading)

        viewModelScope.launch {
            try {
                val albums = albumRepo.getAlbums()
                _uiState.postValue(MainUIState.AlbumLoaded(albums))
            } catch (err: Throwable) {
                err.printStackTrace()
                _uiState.postValue(MainUIState.AlbumLoadError(R.string.error_generic))
                Log.e("MainPresenter", "Error in fetching Pokemon: ${err.message}")
            }
        }

    }
}

sealed class MainUIState {
    data object None : MainUIState()
    data object Loading : MainUIState()
    data class AlbumLoaded(val albums: List<AlbumModel>) : MainUIState()
    data class AlbumLoadError(val error: Int) : MainUIState()

}