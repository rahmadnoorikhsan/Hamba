package com.rahmadev.hamba.core.data.repository

import com.rahmadev.hamba.core.data.source.network.RemoteDataSource
import com.rahmadev.hamba.core.domain.repository.ScheduleRepository
import com.rahmadev.hamba.core.utils.Result
import com.rahmadev.hamba.core.utils.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScheduleRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ScheduleRepository {

    override fun getTimeSchedule(city: String) = flow {
        emit(Result.Loading())
        try {
            val response = remoteDataSource.getTimeSchedule(city)
            val result = response.data.timings.toDomain()
            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)
}