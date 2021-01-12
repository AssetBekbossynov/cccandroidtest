package com.testapp.androidtest.helpers

import android.content.Context
import com.google.gson.Gson
import com.testapp.androidtest.dao.EstimateDao
import com.testapp.androidtest.dao.PersonDao
import com.testapp.androidtest.db.AppDatabase
import com.testapp.androidtest.entity.Estimate
import com.testapp.androidtest.entity.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


object DbUtils {

    suspend fun populateDb(db: AppDatabase?, context: Context) {

        val gson = Gson()

        db?.let {
            withContext(Dispatchers.IO) {
                val personDao: PersonDao = it.personDao()
                val estimateDao: EstimateDao = it.estimateDao()

                personDao.deleteAll()
                estimateDao.deleteAll()

                val result = StringBuilder()
                try {
                    val inputStream = context.assets.open("content.json")
                    val isReader = InputStreamReader(inputStream)
                    val bufferedReader = BufferedReader(isReader)
                    var line: String?
                    while (bufferedReader.readLine().also { line = it } != null)
                        result.append(line)
                    bufferedReader.close()
                    inputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                val contentJson = JSONObject(result.toString())
                val personJson = contentJson.getString("person")
                val estimateJson = contentJson.getString("estimate")

                val person = gson.fromJson<Person>(personJson, Person::class.java)
                val estimate = gson.fromJson<Estimate>(estimateJson, Estimate::class.java)

                async { estimateDao.insert(estimate) }
                async { personDao.insert(person) }
            }
        }
    }
}