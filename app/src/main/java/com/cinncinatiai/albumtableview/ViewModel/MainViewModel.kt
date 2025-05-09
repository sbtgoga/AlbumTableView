package com.cinncinatiai.albumtableview.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cinncinatiai.albumtableview.Model.AlbumModel
import com.cinncinatiai.albumtableview.Repository.AlbumRepository
import com.cinncinatiai.albumtableview.Repository.AlbumRepositoryImpl

class MainViewModel(private val albumRepo: AlbumRepository = AlbumRepositoryImpl(),): ViewModel() {
    private val _uiState = MutableLiveData<MainUIState>(MainUIState.None)
    val uiState: LiveData<MainUIState> = _uiState

    fun onInit() {
        _uiState.postValue(MainUIState.Loading)
        try {
            val albums = albumRepo.getAlbums()
            _uiState.postValue(MainUIState.AlbumLoaded(albums))
        } catch (err: Throwable) {
            err.printStackTrace()
            Log.e("MainPresenter", "Error in fetching Pokemon: ${err.message}")
            //_uiState.postValue(MainUIState.ErrorV2(R.string.error_generic))
        }
    }
}

sealed class MainUIState {
    object None : MainUIState()
    object Loading : MainUIState()
    data class AlbumLoaded(val album: List<AlbumModel>) : MainUIState()

}