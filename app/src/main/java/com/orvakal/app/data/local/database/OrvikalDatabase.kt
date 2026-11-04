package com.orvakal.app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.orvakal.app.data.local.dao.ServiceDao
import com.orvakal.app.data.local.entity.ServiceEntity

@Database(
    entities = [ServiceEntity::class],
    version = 1,
    exportSchema = false
)
abstract class OrvikalDatabase : RoomDatabase() {
    abstract fun serviceDao(): ServiceDao

    companion object {
        const val DATABASE_NAME = "orvakal_db"
    }
}
