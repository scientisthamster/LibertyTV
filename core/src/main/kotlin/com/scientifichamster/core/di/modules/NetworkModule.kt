package com.scientifichamster.core.di.modules

import com.scientifichamster.core.BuildConfig
import com.scientifichamster.core.di.modules.NetworkModule.BindNetworkModule
import com.scientifichamster.core.network.repositories.MovieRepository
import com.scientifichamster.core.network.repositories.MovieRepositoryImpl
import com.scientifichamster.core.network.service.MovieService
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Class that contributes to the object graph [CoreComponent].
 *
 * @see Module
 */
@Module(includes = [BindNetworkModule::class])
class NetworkModule {

    /**
     * Create a provider method binding for [HttpLoggingInterceptor].
     *
     * @return Instance of http interceptor.
     * @see Provides
     */
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    /**
     * Create a provider method binding for [OkHttpClient].
     *
     * @return Instance of http client.
     * @see Provides
     */
    @Singleton
    @Provides
    fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) clientBuilder.addInterceptor(interceptor)
        return clientBuilder.build()
    }

    /**
     * Create a provider method binding for [Retrofit].
     *
     * @return Instance of retrofit.
     * @see Provides
     */
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BuildConfig.TMDB_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    /**
     * Create a provider method binding for [MovieService].
     *
     * @return Instance of movie service.
     * @see Provides
     */
    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)

    @Module
    abstract inner class BindNetworkModule {
        /**
         * Create a provider method binding for [MovieRepository].
         *
         * @return Instance of movie repository.
         * @see Provides
         */
        @Singleton
        @Binds
        abstract fun bindMovieRepositoryImpl(movieRepository: MovieRepositoryImpl): MovieRepository
    }
}