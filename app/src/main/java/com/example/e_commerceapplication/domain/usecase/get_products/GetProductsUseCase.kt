package com.example.e_commerceapplication.domain.usecase.get_products

import com.example.e_commerceapplication.common.Resource
import com.example.e_commerceapplication.data.remote.dto.toProducts
import com.example.e_commerceapplication.domain.model.Products
import com.example.e_commerceapplication.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<Resource<List<Products>>> = flow {

        try {
            emit(Resource.Loading())
            val products = repository.getProducts().map { it.toProducts() }
            emit(Resource.Success(products))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }

    }
}