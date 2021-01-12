package com.testapp.androidtest.repository.estimate

import com.testapp.androidtest.dao.EstimateDao
import com.testapp.androidtest.entity.Estimate

class EstimateRepository(private val estimateDao: EstimateDao): IEstimateRepository {

    override suspend fun insert(estimate: Estimate) {
        estimateDao.insert(estimate)
    }

    override suspend fun deleteAll() {
        estimateDao.deleteAll()
    }

    override suspend fun getAll(): Estimate {
        return estimateDao.getAllEstimate()
    }
}