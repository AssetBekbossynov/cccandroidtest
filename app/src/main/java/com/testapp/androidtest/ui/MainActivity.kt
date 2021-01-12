package com.testapp.androidtest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.testapp.androidtest.R
import com.testapp.androidtest.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_detail.view.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        initLayout()

        binding.vm = viewModel
        binding.apply {
            lifecycleOwner = this@MainActivity
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getData()
    }

    private fun initLayout() {
        layoutEstNumber.tvLabel.text = getString(R.string.est_number)
        layoutCreated.tvLabel.text = getString(R.string.created)
        layoutRequester.tvLabel.text = getString(R.string.requester)
        layoutRevisionNumber.tvLabel.text = getString(R.string.revision_number)
        layoutCreatedBy.tvLabel.text = getString(R.string.created_by)
        layoutContact.tvLabel.text = getString(R.string.contact)
    }
}