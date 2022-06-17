package com.scientifichamster.core.network.models

/**
 * Moviedb API data network response format.
 *
 * @param page The current page from which we take data.
 * @param total_results The total number of films.
 * @param total_pages The total number of pages with films.
 * @param results The list of [T] returned by the call.
 */
data class DataResponse<T>(
    val page: Int,
    val results: List<T>,
    val total_results: Int,
    val total_pages: Int,
    val dates: Dates
)
