package com.mad4n7.maddiceroller

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform