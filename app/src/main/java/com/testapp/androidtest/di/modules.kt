package com.testapp.androidtest.di

import com.testapp.androidtest.dao.EstimateDao
import com.testapp.androidtest.dao.PersonDao
import com.testapp.androidtest.db.AppDatabase
import com.testapp.androidtest.repository.estimate.EstimateRepository
import com.testapp.androidtest.repository.person.PersonRepository
import com.testapp.androidtest.ui.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    fun getPersonDao(database: AppDatabase): PersonDao {
        return database.personDao()
    }

    fun getEstimateDao(database: AppDatabase): EstimateDao {
        return database.estimateDao()
    }

    single { AppDatabase.getDatabase(androidContext()) }
    single { getPersonDao(get()) }
    single { getEstimateDao(get()) }
}

val repositoryModule = module {

    single { EstimateRepository(get()) }
    single { PersonRepository(get()) }

}

val viewModelModule = module {
    single { MainViewModel() }
}