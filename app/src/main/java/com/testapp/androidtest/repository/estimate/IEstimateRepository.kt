package com.testapp.androidtest.repository.estimate

import com.testapp.androidtest.entity.Estimate
import io.reactivex.Flowable

interface IEstimateRepository {

    suspend fun insert(estimate: Estimate)

    suspend fun deleteAll()

    fun getAll(): Flowable<Estimate>
}