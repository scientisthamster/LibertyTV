package com.scientifichamster.core.network.service

import com.scientifichamster.core.network.models.BaseResponse
import com.scientifichamster.core.network.models.MovieDetailsResponse
import com.scientifichamster.core.network.models.PopularMoviesResponse
import com.scientifichamster.core.network.models.UpcomingMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Representation interface of the Moviedb API endpoints.
 */
interface MovieService {

    /**
     * Get the primary information about a movie..
     * @param movieId id of the specific movie.
     * @param apiKey A unique identifier used to authenticate all calling to an API.
     */
    @GET("/movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): BaseResponse<MovieDetailsResponse>

    /**
     * Get a list of the current popular movies on TMDB. This list updates daily..
     * @param apiKey A unique identifier used to authenticate all calling to an API.
     */
    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): BaseResponse<PopularMoviesResponse>

    /**
     * Get a list of upcoming movies in theatres.
     * @param apiKey A unique identifier used to authenticate all calling to an API.
     */
    @GET("/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String
    ): BaseResponse<UpcomingMoviesResponse>
}