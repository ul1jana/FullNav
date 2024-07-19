package com.example.navibar.ui.tags

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TagsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Tags fragment"
    }
    val text: LiveData<String> = _text
}