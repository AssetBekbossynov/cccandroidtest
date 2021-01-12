package com.testapp.androidtest.entity

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "estimate",
    indices = [
        Index(value = ["created_by"], unique = true),
        Index(value = ["requested_by"], unique = true),
        Index(value = ["contact"], unique = true)
    ]
)
data class Estimate(
    @PrimaryKey val id: String,
    @ColumnInfo val address: String,
    @ColumnInfo val company: String,
    @ColumnInfo val contact: String,
    @ColumnInfo val number: Int,

    @ColumnInfo(name = "created_by")
    @SerializedName("created_by")
    val createdBy: String,

    @ColumnInfo(name = "created_date")
    @SerializedName("created_date")
    val createdDate: String,


    @ColumnInfo(name = "requested_by")
    @SerializedName("requested_by")
    val requestedBy: String,

    @ColumnInfo(name = "revision_number")
    @SerializedName("revision_number")
    val revisionNumber: Int
)