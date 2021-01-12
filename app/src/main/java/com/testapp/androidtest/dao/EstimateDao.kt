package com.testapp.androidtest.dao

import androidx.room.*
import com.testapp.androidtest.entity.Estimate
import io.reactivex.Flowable

@Dao
interface EstimateDao {

    @Insert
    suspend fun insert(estimate: Estimate)

    @Query("DELETE FROM estimate")
    suspend fun deleteAll()

    @Query("SELECT * from estimate")
    fun getAllEstimate(): Flowable<Estimate>

}