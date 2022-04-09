package com.example.parstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.parse.ParseUser

class ProfileFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val name = ParseUser.getCurrentUser().get("username")
        val textView: TextView = view.findViewById(R.id.tvUsername) as TextView
        textView.text = name.toString()

        view.findViewById<Button>(R.id.logoutBtn).setOnClickListener {
            logoutUser()
        }

        view.findViewById<Button>(R.id.changeUsrBtn).setOnClickListener {
            val intent = Intent(context, changeUsername::class.java)
            startActivity(intent)
        }

        view.findViewById<Button>(R.id.changePWBtn).setOnClickListener {
            val intent = Intent(activity, changeUsername::class.java)
            startActivity(intent)
        }
    }

    fun logoutUser(){
        ParseUser.logOut()
        val currentUser = ParseUser.getCurrentUser() // this will now be null
        goToLoginActivity()
    }


    private fun goToLoginActivity() {
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
        activity?.finish()

    }



}