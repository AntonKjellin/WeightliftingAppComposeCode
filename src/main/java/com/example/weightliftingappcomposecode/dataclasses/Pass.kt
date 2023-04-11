package com.example.weightliftingappcomposecode.dataclasses

import com.google.firebase.Timestamp

data class Pass (
    var passName : String? = "",
    var passType : PassTemplate? = null,
    var PassDate : Timestamp? = null
        )