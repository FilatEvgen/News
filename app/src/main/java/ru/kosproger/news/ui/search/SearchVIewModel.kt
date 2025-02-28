package ru.kosproger.news.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.kosproger.news.data.api.NewsRepository
import ru.kosproger.news.models.NewsResponse
import ru.kosproger.news.utils.Resource
import javax.inject.Inject

@HiltViewModel
class SearchVIewModel @Inject constructor(private val repository: NewsRepository): ViewModel(){

    val searchNewsLiveData: MutableLiveData <Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1

    init {
        getSearchNews( "")
    }

    fun getSearchNews(query: String) =
        viewModelScope.launch {
            searchNewsLiveData.postValue(Resource.Loading())
            val response = repository.getSearchNews(query = query, pageNumber = searchNewsPage)
            if (response.isSuccessful) {
                response.body().let { res ->
                    searchNewsLiveData.postValue(Resource.Success(res))
                }
            } else {
                searchNewsLiveData.postValue((Resource.Error(message = response.message())))
            }
        }

}