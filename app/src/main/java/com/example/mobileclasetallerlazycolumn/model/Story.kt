package com.example.mobileclasetallerlazycolumn.model

data class Story(
    val id: Int,
    val username: String,
    val profileImageUrl: String,
    val hasSeen: Boolean = false
    )
