package com.cinncinatiai.albumtableview

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.cinncinatiai.albumtableview.ViewModel.MainUIState
import com.cinncinatiai.albumtableview.ViewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        MainViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        viewModel.onInit()
        viewModel.uiState.observe(this) { OnUIState(it) }
    }
}

private fun OnUIState(uiState: MainUIState) {
    when (uiState) {
        is MainUIState.AlbumLoaded -> Log.i("MainActivity", uiState.album.toString())
        MainUIState.Loading -> {} //NOOP
        MainUIState.None -> {} //NOOP
    }
}
