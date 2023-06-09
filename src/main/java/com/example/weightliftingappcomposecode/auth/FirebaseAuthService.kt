package com.example.weightliftingappcomposecode.auth

import android.app.Activity
import com.example.weightliftingappcomposecode.dataclasses.AppUser
import com.google.firebase.auth.FirebaseAuth
import dev.kjellin.weightliftingapp3.data.DatabaseFirestore

class FirebaseAuthService {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseFirestore


    // Create user and necessary files for the user.
    fun createUser(
        email: String,
        password: String,
        user: AppUser,
        callBack: (Boolean) -> Unit
    ) {
        auth = FirebaseAuth.getInstance()
        db = DatabaseFirestore()
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                db.addUser(user)
                callBack.invoke(true)
            } else {
                callBack.invoke(false)
            }
        }.addOnFailureListener {
            callBack.invoke(false)
        }
    }

    // Login User who has an account.
    fun loginUser(
        email: String,
        password: String,
        callBack: (Boolean) -> Unit
    ) {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                callBack.invoke(true)
            } else {
                callBack.invoke(false)
            }
        }.addOnFailureListener {
            callBack.invoke(false)
        }
    }

    // Logout user.
    fun logoutUser() {
        auth = FirebaseAuth.getInstance()
        auth.signOut()
    }

}