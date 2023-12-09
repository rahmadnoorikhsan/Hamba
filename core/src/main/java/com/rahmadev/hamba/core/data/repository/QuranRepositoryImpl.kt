package com.rahmadev.hamba.core.data.repository

import com.rahmadev.hamba.core.data.source.network.RemoteDataSource
import com.rahmadev.hamba.core.domain.repository.QuranRepository
import com.rahmadev.hamba.core.utils.Result
import com.rahmadev.hamba.core.utils.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuranRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : QuranRepository {
    override fun getSurah() = flow {
        emit(Result.Loading())
        try {
            val response = remoteDataSource.getSurah()
            val result = response.data.map { it.toDomain() }
            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    override fun getSurahById(id: Int) = flow {
        emit(Result.Loading())
        try {
            val response = remoteDataSource.getDetailSurah(id)
            val result = response.data?.toDomain()
            if (result != null) {
                emit(Result.Success(result))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)
}