package be.nmine.gtd.infrastructure.basket

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inbox_zero")
data class InboxZeroRoom(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "timestamp") var timestamp: Long?,
    @ColumnInfo(name = "name") var name: String
)