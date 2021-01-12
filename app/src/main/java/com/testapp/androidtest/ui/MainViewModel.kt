package com.testapp.androidtest.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.testapp.androidtest.entity.EstimateAndPerson
import com.testapp.androidtest.repository.estimate.IEstimateRepository
import com.testapp.androidtest.repository.person.IPersonRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel (private val estimateRepository: IEstimateRepository,
                     private val personRepository: IPersonRepository): ViewModel() {

    var data: ObservableField<EstimateAndPerson> = ObservableField()

    private var estimateAndPerson: EstimateAndPerson? = null

    fun getData() {
        estimateRepository.getAll()
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                estimateAndPerson = EstimateAndPerson(it.address, it.company, it.contact, it.number,
                    it.createdBy, it.createdDate, it.requestedBy, it.revisionNumber)

                personRepository.getPersonById(it.createdBy)
            }
            .subscribe(
                {
                    estimateAndPerson!!.contact = "${it.firstName} ${it.lastName}"
                    estimateAndPerson!!.createdBy = "${it.firstName} ${it.lastName}"
                    estimateAndPerson!!.requestedBy = "${it.firstName} ${it.lastName}"
                    data.set(estimateAndPerson)
                }, {
                    data.set(null)
                })
    }
}