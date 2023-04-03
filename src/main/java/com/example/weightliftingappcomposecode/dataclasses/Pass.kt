package com.example.weightliftingappcomposecode.dataclasses

import com.google.firebase.Timestamp

data class Pass (
    var passName : String? = null,
    var passType : PassTemplate? = null,
    var PassDate : Timestamp? = null
        )