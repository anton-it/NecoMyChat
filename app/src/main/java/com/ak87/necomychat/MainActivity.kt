package com.ak87.necomychat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ak87.necomychat.databinding.ActivityMainBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        // Write a message to the database
        //
        val database = Firebase.database
        val myRef = database.getReference("message")

        with(binding) {
            btnSent.setOnClickListener {
                myRef.setValue(etMessage.text.toString())
            }
        }

        onChangeListener(myRef)

    }

    private fun onChangeListener(dRef: DatabaseReference) {
        dRef.addValueEventListener(object  : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    tvMessage.append("\n")
                    tvMessage.append(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}