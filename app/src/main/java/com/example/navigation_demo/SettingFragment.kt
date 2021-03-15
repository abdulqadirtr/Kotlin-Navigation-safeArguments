package com.example.navigation_demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavGraph
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment(R.layout.fragment_setting) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_default_amount.setText(SampleData.defaultAmount.value.toString())
        btn_save_default_amount.setOnClickListener {
            val deafaultValue = et_default_amount.text.toString().toLong()
            SampleData.defaultAmount.value = deafaultValue
        }

        btn_about_app.setOnClickListener {
            val action = NavGraphDirections.actionGlobalAboutFragment("test")
            findNavController().navigate(action)
        }
    }
}