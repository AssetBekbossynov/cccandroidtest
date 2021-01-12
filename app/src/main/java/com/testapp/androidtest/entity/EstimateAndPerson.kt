package com.testapp.androidtest.entity

data class EstimateAndPerson(
    val address: String,
    val company: String,
    var contact: String,
    val number: Int,
    var createdBy: String,
    val createdDate: String,
    var requestedBy: String,
    val revisionNumber: Int
)