package com.testapp.androidtest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.testapp.androidtest.entity.Person
import io.reactivex.Flowable

@Dao
interface PersonDao {

    @Insert
    suspend fun insert(person: Person)

    @Query("DELETE FROM person")
    suspend fun deleteAll()

    @Query("SELECT * from person")
    fun getAllPerson(): Flowable<Person>

    @Query("SELECT * from person WHERE id = :id")
    fun getPersonById(id: String): Flowable<Person>
}