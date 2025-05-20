package com.example.a044_petisoin.model

import androidx.room.TypeConverters
import java.util.Date

class DateConverter {
    @TypeConverters
    fun timestampToDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }
    @TypeConverters
    fun datetoTimestamp(date: Date?):Long? {
        return date?.time?.toLong()
    }
}