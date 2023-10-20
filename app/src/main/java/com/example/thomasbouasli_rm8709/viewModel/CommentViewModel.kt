package com.example.thomasbouasli_rm8709.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thomasbouasli_rm8709.models.Comment
import com.example.thomasbouasli_rm8709.utils.CommentsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentViewModel : ViewModel() {
    private val api = CommentsApi().getApi()

    val liveComments = MutableLiveData<List<Comment>>()
    val liveError = MutableLiveData<String>()

    fun getComments(){
        api.getComments().enqueue(object : Callback<List<Comment>>{
            override fun onResponse(
                call: Call<List<Comment>>,
                response: Response<List<Comment>>
            ) {
                Log.i("COMMENT_RESPONSE", response.body().toString())
                liveComments.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Log.i("COMMENT_RESPONSE", t.message.toString())
                liveError.postValue(t.message)
            }
        })
    }
}