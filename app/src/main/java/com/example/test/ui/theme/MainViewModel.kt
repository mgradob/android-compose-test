package com.example.test.ui.theme

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.test.ui.theme.views.PostModel

class MainViewModel : ViewModel() {

    var posts = mutableStateListOf<PostModel>()
        private set

    fun createRandomPost() {
        posts.add(PostModel())
    }
}