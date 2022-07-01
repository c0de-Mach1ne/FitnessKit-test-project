package com.example.fitnesskittestproject.model

open class ListItem(
    val type: Int
) {
    companion object{
        const val TYPE_DATE = 0
        const val TYPE_LESSON = 1
    }
}