package com.scientifichamster.core.di.modules

import com.scientifichamster.core.utils.ThemeUtils
import com.scientifichamster.core.utils.ThemeUtilsImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Class that contributes to the object graph [CoreComponent].
 *
 * @see Module
 */
@Module
abstract class UtilsModule {

    /**
     * Create a provider method binding for [ThemeUtilsImpl].
     *
     * @return Instance of theme utils.
     * @see Binds
     */
    @Singleton
    @Binds
    abstract fun bindThemeUtils(themeUtils: ThemeUtilsImpl): ThemeUtils
}