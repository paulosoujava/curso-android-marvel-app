package com.paulo.core.usecase.base

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

abstract class UseCase<in P, R>{
    operator fun invoke(params: P): Flow<ResultStatus<R>>{
        return flow {
            emit(ResultStatus.Loading)
            emit(doWork(params))
        }.catch {  throwable ->
            emit(ResultStatus.Error(throwable))
        }
    }

    protected abstract suspend fun doWork(params: P): ResultStatus<R>
}

abstract class  PagingUseCase<in P, R: Any>{
    operator fun invoke(params: P): Flow<PagingData<R>> = createFlowObservable(params)

    abstract fun createFlowObservable(params: P): Flow<PagingData<R>>
}