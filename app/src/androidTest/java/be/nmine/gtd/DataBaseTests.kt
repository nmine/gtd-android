package be.nmine.gtd

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import be.nmine.gtd.infrastructure.basket.BasketRoomDao
import be.nmine.gtd.infrastructure.basket.StuffRoom
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
@RunWith(AndroidJUnit4::class)
class DataBaseTests {
    private lateinit var basketRoomDao: BasketRoomDao
    private lateinit var database: ApplicationTestDatabase

    @Before
    fun createDb() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), ApplicationTestDatabase::class.java
        ).build()
        basketRoomDao = database.basketRoomDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

    @InternalCoroutinesApi
    @Test
    suspend fun writeUserAndReadInList() = runBlocking {
        val stuff = StuffRoom(name = "name")
        basketRoomDao.save(stuff)
//        basketRoomDao.getAll().collect { value: List<StuffRoom> ->
//            assert(value[0]!!.name == "name")
//        }
    }
}