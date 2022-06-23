package com.example.fitnesskittestproject.date

import android.app.Application

// simple singleton
class App: Application() {
    val responseService = ResponseService()
}