package be.nmine.gtd.core.infrastructure

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StuffDao {
    @Query("SELECT * FROM stuffs")
    fun getAll(): List<Stuff>

    @Insert
    fun insertAll(stuff: Stuff)

    @Delete
    fun delete(stuff: Stuff)
}