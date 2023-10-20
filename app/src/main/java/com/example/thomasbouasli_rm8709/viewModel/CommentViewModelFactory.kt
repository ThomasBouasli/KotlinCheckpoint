package com.example.thomasbouasli_rm8709.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CommentViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return with(modelClass){
            when{
                isAssignableFrom(CommentViewModel::class.java) -> CommentViewModel()
                else -> throw IllegalArgumentException("Unknown ViewModel class")
            }
        } as T
    }
}