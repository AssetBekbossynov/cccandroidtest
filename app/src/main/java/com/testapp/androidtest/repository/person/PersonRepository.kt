package com.testapp.androidtest.repository.person

import com.testapp.androidtest.dao.PersonDao
import com.testapp.androidtest.entity.Person
import io.reactivex.Flowable

class PersonRepository(private val personDao: PersonDao): IPersonRepository {

    override suspend fun insert(person: Person) {
        personDao.insert(person)
    }

    override suspend fun deleteAll() {
        personDao.deleteAll()
    }

    override fun getAll(): Flowable<Person> {
        return personDao.getAllPerson()
    }

    override fun getPersonById(id: String): Flowable<Person> {
        return personDao.getPersonById(id)
    }
}