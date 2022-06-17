package com.scientifichamster.core.network.repositories

import com.scientifichamster.core.network.models.BaseResponse
import com.scientifichamster.core.network.models.MovieDetailsResponse
import com.scientifichamster.core.network.models.PopularMoviesResponse
import com.scientifichamster.core.network.models.UpcomingMoviesResponse

interface MovieRepository {

    suspend fun getMovieDetails(movieId: Int, apiKey: String): BaseResponse<MovieDetailsResponse>

    suspend fun getPopularMovies(apiKey: String): BaseResponse<PopularMoviesResponse>

    suspend fun getUpcomingMovies(apiKey: String): BaseResponse<UpcomingMoviesResponse>
}