package az.isfan.composechallenge.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import az.isfan.composechallenge.data.local.dao.DeviceDao
import az.isfan.composechallenge.domain.models.local.DeviceEntity

@Database(
    entities = [
        DeviceEntity::class,
    ],
    version=1,
    exportSchema = false
)
abstract class Db: RoomDatabase() {
    abstract fun deviceDao(): DeviceDao

    companion object{
        @Volatile
        private var INSTANCE: Db? = null

        fun getDB(context: Context): Db {
            val instance = INSTANCE
            if (instance != null){
                return instance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Db::class.java,
                    "store_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}