package com.scientifichamster.core.di

import android.content.Context
import com.scientifichamster.core.di.modules.ContextModule
import com.scientifichamster.core.di.modules.NetworkModule
import com.scientifichamster.core.di.modules.UtilsModule
import com.scientifichamster.core.network.repositories.MovieRepository
import com.scientifichamster.core.network.service.MovieService
import com.scientifichamster.core.utils.ThemeUtils
import dagger.Component
import javax.inject.Singleton

/**
 * Core component that all module's components depend on.
 *
 * @see Component
 */
@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        UtilsModule::class,
    ]
)
interface CoreComponent {

    /**
     * Provide dependency graph Context
     *
     * @return Context
     */
    fun context(): Context

    /**
     * Provide dependency graph MovieService
     *
     * @return MovieService
     */
    fun movieService(): MovieService

    /**
     * Provide dependency graph MovieRepository
     *
     * @return MovieRepository
     */
    fun movieRepository(): MovieRepository

    /**
     * Provide dependency graph ThemeUtils
     *
     * @return ThemeUtils
     */
    fun themeUtils(): ThemeUtils
}