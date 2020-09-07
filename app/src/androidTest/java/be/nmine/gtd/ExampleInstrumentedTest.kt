//package be.nmine.gtd
//
//import androidx.room.Room
//import androidx.test.core.app.ApplicationProvider
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import androidx.test.platform.app.InstrumentationRegistry
//import be.nmine.gtd.infrastructure.basket.BasketRoomDao
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//
///**
// * Instrumented test, which will execute on an Android device.
// *
// * See [testing documentation](http://d.android.com/tools/testing).
// */
//@RunWith(AndroidJUnit4::class)
//class ExampleInstrumentedTest {
//    private lateinit var basketRoomDao: BasketRoomDao
//    private lateinit var database: ApplicationTestDatabase
//
//    @Before
//    fun createDb() {
//        database = Room.inMemoryDatabaseBuilder(
//            ApplicationProvider.getApplicationContext(), ApplicationTestDatabase::class.java
//        ).build()
//        basketRoomDao = database.basketRoomDao()
//    }
//
//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("be.nmine.gtd", appContext.packageName)
//    }
//}