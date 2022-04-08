package com.example.parstagram.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parstagram.LoginActivity
import com.example.parstagram.MainActivity
import com.example.parstagram.Post
import com.example.parstagram.R
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
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