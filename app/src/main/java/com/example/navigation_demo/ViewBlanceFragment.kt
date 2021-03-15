package com.example.navigation_demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_view_blance.*

class ViewBlanceFragment : Fragment(R.layout.fragment_view_blance) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnTest.setOnClickListener {

            val action = ViewBlanceFragmentDirections.actionViewBlanceFragmentToSendCashFragment("Test")
            findNavController().navigate(action)
        }

    }

}