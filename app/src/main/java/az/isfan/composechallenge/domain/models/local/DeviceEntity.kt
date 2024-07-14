package az.isfan.composechallenge.domain.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "devices")
data class DeviceEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val data: String?
)