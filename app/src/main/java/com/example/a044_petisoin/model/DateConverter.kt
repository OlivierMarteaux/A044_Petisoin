package com.example.a044_petisoin.model

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun timestampToDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }
    @TypeConverter
    fun datetoTimestamp(date: Date?):Long? {
        return date?.time?.toLong()
    }
}