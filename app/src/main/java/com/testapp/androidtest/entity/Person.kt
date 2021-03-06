package com.testapp.androidtest.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "person")
data class Person(
    @PrimaryKey val id: String,
    @ColumnInfo val email: String,
    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    @SerializedName("last_name")
    val lastName: String,
    @ColumnInfo(name = "phone_number")
    @SerializedName("phone_number")
    val phoneNumber: String
)