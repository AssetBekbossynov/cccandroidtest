package com.testapp.androidtest.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.testapp.androidtest.entity.Person

@Dao
interface PersonDao {

    @Insert
    suspend fun insert(person: Person)

    @Query("DELETE FROM person")
    suspend fun deleteAll()

    @Query("SELECT * from person")
    suspend fun getAllPerson(): Person

    @Query("SELECT * from person WHERE id = :id")
    suspend fun getPersonById(id: String): Person
}