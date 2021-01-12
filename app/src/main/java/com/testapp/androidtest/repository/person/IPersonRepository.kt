package com.testapp.androidtest.repository.person

import com.testapp.androidtest.entity.Person

interface IPersonRepository {

    suspend fun insert(person: Person)

    suspend fun deleteAll()

    suspend fun getAll(): Person

    suspend fun getPersonById(id: String): Person
}