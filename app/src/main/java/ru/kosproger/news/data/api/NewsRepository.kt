package ru.kosproger.news.data.api

import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsService: NewsService) {
    suspend fun getNews(countryCode: String, pageNumber: Int,   category: String) =
        newsService.getHeadlines(countryCode = countryCode, page = pageNumber, category = category)
}