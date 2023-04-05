package com.example.weightliftingappcomposecode.dataclasses

data class AppUser (
    var name : String? = null,
    var passesDone: Int? = null,
    var templateGroups: ArrayList<TemplateGroup>?= null
)
