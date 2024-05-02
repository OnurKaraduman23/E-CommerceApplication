package com.example.e_commerceapplication.di

import com.example.e_commerceapplication.common.Constants.BASE_URL
import com.example.e_commerceapplication.data.EcommerceApi
import com.example.e_commerceapplication.data.repository.ProductsRepositoryImpl
import com.example.e_commerceapplication.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEcommerceApi(): EcommerceApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EcommerceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(api: EcommerceApi): ProductRepository {
        return ProductsRepositoryImpl(api)
    }


}