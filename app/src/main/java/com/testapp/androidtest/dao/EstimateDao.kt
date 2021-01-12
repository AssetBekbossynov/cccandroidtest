package com.testapp.androidtest.dao

import androidx.room.*
import com.testapp.androidtest.entity.Estimate

@Dao
interface EstimateDao {

    @Insert
    suspend fun insert(estimate: Estimate)

    @Query("DELETE FROM estimate")
    suspend fun deleteAll()

    @Query("SELECT * from estimate")
    suspend fun getAllEstimate(): Estimate

}