package com.ak87.necomychat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Write a message to the database
        //
        val database = Firebase.database("https://mychat-9ff6d-default-rtdb.firebaseio.com")
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
    }
}