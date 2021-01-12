package com.testapp.androidtest.repository.person

import com.testapp.androidtest.dao.PersonDao
import com.testapp.androidtest.entity.Person

class PersonRepository(private val personDao: PersonDao): IPersonRepository {

    override suspend fun insert(person: Person) {
        personDao.insert(person)
    }

    override suspend fun deleteAll() {
        personDao.deleteAll()
    }

    override suspend fun getAll(): Person {
        return personDao.getAllPerson()
    }

    override suspend fun getPersonById(id: String): Person {
        return personDao.getPersonById(id)
    }
}