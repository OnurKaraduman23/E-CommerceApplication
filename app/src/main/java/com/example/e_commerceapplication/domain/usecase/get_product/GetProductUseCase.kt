package com.example.e_commerceapplication.domain.usecase.get_product

import com.example.e_commerceapplication.common.Resource
import com.example.e_commerceapplication.data.remote.dto.toProduct
import com.example.e_commerceapplication.domain.model.Product
import com.example.e_commerceapplication.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    operator fun invoke(productId: Int): Flow<Resource<Product>> = flow {

        try {
            emit(Resource.Loading())
            val product = repository.getProduct(productId).toProduct()
            emit(Resource.Success(product))
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}