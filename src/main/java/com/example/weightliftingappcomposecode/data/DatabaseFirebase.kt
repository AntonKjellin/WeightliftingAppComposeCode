package dev.kjellin.weightliftingapp3.data

import android.util.Log
import com.example.weightliftingappcomposecode.dataclasses.AppUser
import com.example.weightliftingappcomposecode.dataclasses.Exercise
import com.example.weightliftingappcomposecode.dataclasses.ExerciseSet
import com.example.weightliftingappcomposecode.dataclasses.PassTemplate
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase

class DatabaseFirestore {
    private var db = FirebaseFirestore.getInstance()
    private var auth = Firebase.auth

    fun addUser(user: AppUser) {

        val userID = auth.uid
        val userCol = db.collection("users")

        val sets =ArrayList<ExerciseSet>()
        sets.add(ExerciseSet(5, 85))
        sets.add(ExerciseSet(4, 80))
        val exercises = ArrayList<Exercise>()
        exercises.add(Exercise("Romanian DL", sets))
        exercises.add(Exercise("Deadlifts", sets))



        //Add essential documents and collections for the user.
        userCol.document(userID!!)
            .set(user)
            .addOnSuccessListener { Log.d("Debug", "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w("Debug", "Error writing document", e) }

        val currentUserDoc = userCol.document(userID)

        currentUserDoc.collection("passesDone").document("Sample").set(
            hashMapOf(
                "desc" to "Sample"
            )
        )

        currentUserDoc.collection("passTemplates").document("Example").set(PassTemplate("Example", exercises))

    }

    fun addPassTemplate(passTemplate: PassTemplate) {
        val userID = auth.uid
        val dbRef = db.collection("users").document(userID.toString()).collection("passTemplates")
        dbRef.add(passTemplate)
    }

    fun getUserData(callBack:(AppUser) -> Unit){
        val userID = auth.uid
        val userRef = db.collection("users").document(userID.toString())
        userRef.get().addOnSuccessListener {
            val user = it.toObject<AppUser>()!!
            callBack.invoke(user)
        }
    }

    fun getPassTemplates(callBack: (ArrayList<PassTemplate>) -> Unit){
        val userId = auth.uid
        val templateRef = db.collection("users").document(userId.toString()).collection("passTemplates")
        templateRef.get().addOnSuccessListener {
            val passTemplates = it.toObjects<PassTemplate>()
            callBack.invoke(passTemplates as ArrayList<PassTemplate>)
        }
    }

    fun addPassTemplates(pass : PassTemplate, callBack: (Boolean) -> Unit){
        val userId = auth.uid
        val templateRef = db.collection("users").document(userId.toString()).collection("passTemplates")
        templateRef.add(pass).addOnSuccessListener {
            callBack.invoke(true)
        }
    }
}
