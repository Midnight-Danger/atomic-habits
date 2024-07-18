package com.daily.atomic.habits

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform