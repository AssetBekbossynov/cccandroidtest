package com.testapp.androidtest.repository.estimate

import com.testapp.androidtest.entity.Estimate

interface IEstimateRepository {

    suspend fun insert(estimate: Estimate)

    suspend fun deleteAll()

    suspend fun getAll(): Estimate
}