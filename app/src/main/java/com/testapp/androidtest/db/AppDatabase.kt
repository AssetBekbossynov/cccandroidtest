package com.testapp.androidtest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.testapp.androidtest.dao.EstimateDao
import com.testapp.androidtest.dao.PersonDao
import com.testapp.androidtest.entity.Estimate
import com.testapp.androidtest.entity.Person
import com.testapp.androidtest.helpers.DbUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [Person::class, Estimate::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    abstract fun estimateDao(): EstimateDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            synchronized(AppDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "test.db")
                        .addCallback(object : Callback() {
                            override fun onOpen(db: SupportSQLiteDatabase) {
                                super.onOpen(db)
                                GlobalScope.launch(Dispatchers.IO) {
                                    DbUtils.populateDb(INSTANCE, context.applicationContext)
                                }
                            }
                        })
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}