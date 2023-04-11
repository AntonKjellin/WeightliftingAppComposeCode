package com.example.weightliftingappcomposecode.dataclasses

data class AppUser (
    var name : String? = "",
    var passesDone: Int? = 0,
    var templateGroups: ArrayList<TemplateGroup>?= null
)
