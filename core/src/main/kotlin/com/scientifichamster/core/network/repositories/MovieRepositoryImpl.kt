package com.scientifichamster.core.network.repositories

import com.scientifichamster.core.network.models.BaseResponse
import com.scientifichamster.core.network.models.MovieDetailsResponse
import com.scientifichamster.core.network.models.PopularMoviesResponse
import com.scientifichamster.core.network.models.UpcomingMoviesResponse
import com.scientifichamster.core.network.service.MovieService
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    internal val movieService: MovieService
) : MovieRepository {

    override suspend fun getMovieDetails(
        movieId: Int,
        apiKey: String
    ): BaseResponse<MovieDetailsResponse> {
        return movieService.getMovieDetails(
            movieId = movieId,
            apiKey = apiKey
        )
    }

    override suspend fun getPopularMovies(apiKey: String): BaseResponse<PopularMoviesResponse> {
        return movieService.getPopularMovies(apiKey = apiKey)
    }

    override suspend fun getUpcomingMovies(apiKey: String): BaseResponse<UpcomingMoviesResponse> {
        return movieService.getUpcomingMovies(apiKey = apiKey)
    }
}