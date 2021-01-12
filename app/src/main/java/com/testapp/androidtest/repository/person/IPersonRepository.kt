package com.testapp.androidtest.repository.person

import com.testapp.androidtest.entity.Person
import io.reactivex.Flowable

interface IPersonRepository {

    suspend fun insert(person: Person)

    suspend fun deleteAll()

    fun getAll(): Flowable<Person>

    fun getPersonById(id: String): Flowable<Person>
}