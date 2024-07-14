package az.isfan.composechallenge.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import az.isfan.composechallenge.domain.models.local.DeviceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(device: DeviceEntity)

    @Query("SELECT * FROM devices")
    fun getAll(): Flow<List<DeviceEntity>>
}