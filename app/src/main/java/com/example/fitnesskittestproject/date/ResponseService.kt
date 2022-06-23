package com.example.fitnesskittestproject.date

import android.content.Context
import com.example.fitnesskittestproject.model.Response
import com.google.gson.GsonBuilder

class ResponseService {

    private val gson = GsonBuilder().create()

    fun getResponse(context: Context): Response {
        val date = readAssetFileToString(context)
        return gson.fromJson(date, Response::class.java)
    }

    private fun readAssetFileToString(context: Context): String {
        val stream = context.assets.open("data.json")
        return stream.bufferedReader().readText()
    }
}