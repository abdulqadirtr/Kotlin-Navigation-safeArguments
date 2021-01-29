package com.example.navigation_demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val navControl= findNavController()
        view.btn_view_balance.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToViewFragment()
            navControl.navigate(action)

        }

       view. btn_transactions.setOnClickListener{
           //recommended way for fragment actions
           val action = HomeFragmentDirections.actionHomeFragmentToViewBlanceFragment()
           navControl.navigate(action)

       }

       view. btn_send_money.setOnClickListener{
           val action = HomeFragmentDirections.actionHomeFragmentToChoseReceiverFragment()
           navControl.navigate(action)

       }
        return view
    }
}
