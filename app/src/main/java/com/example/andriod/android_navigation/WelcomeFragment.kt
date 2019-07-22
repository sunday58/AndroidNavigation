package com.example.andriod.android_navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
val view = "view"

class WelcomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
     val view =   inflater.inflate(R.layout.fragment_welcome, container, false)
        view.findViewById<Button>(R.id.button_registration).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_registrationFragment))

        view.findViewById<Button>(R.id.button)
            .setOnClickListener {
                val email = view.editTextEmail.text.toString()
                val password = view.editTextPassword.text.toString()
                if (email.isNotEmpty() && password.isNotEmpty()){
                    findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
                }
            }

        return view
    }


}
