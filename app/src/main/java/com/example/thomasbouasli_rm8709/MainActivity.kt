package com.example.thomasbouasli_rm8709

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.thomasbouasli_rm8709.databinding.ActivityMainBinding
import com.example.thomasbouasli_rm8709.models.Comment
import com.example.thomasbouasli_rm8709.viewModel.CommentViewModel
import com.example.thomasbouasli_rm8709.viewModel.CommentViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    private val commentFactory = CommentViewModelFactory()
    private lateinit var viewModel: CommentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        viewModel = ViewModelProvider(this, commentFactory)[CommentViewModel::class.java]

        setupObservers()

        viewModel.getComments()

    }

    private fun setupObservers(){
        viewModel.liveComments.observe(
            this,
            Observer(::setCommentId)
        )

        viewModel.liveError.observe(
            this,
            Observer(::setError)
        )
    }

    private fun setCommentId(comments: List<Comment>){
        Log.i("COMMENT_RESPONSE_2", comments.toString())
    }

    private fun setError(error: String){
        Log.i("COMMENT_RESPONSE_2", error)
    }
}