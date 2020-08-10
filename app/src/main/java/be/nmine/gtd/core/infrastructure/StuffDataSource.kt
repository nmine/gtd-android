package be.nmine.gtd.core.infrastructure


import android.os.Handler
import android.os.Looper
import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject

/**
 * Data manager class that handles data manipulation between the database and the UI.
 */
class StuffDataSource @Inject constructor(private val stuffDao: StuffDao) : Basket {

    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)
    private val mainThreadHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    override fun saveStuff(stuff: Stuff) {
        executorService.execute {
            stuffDao.insertAll(
                be.nmine.gtd.core.infrastructure.Stuff(name=stuff.name)
            )
        }
    }

    @Override
    override fun getStuff(stuff: String): Stuff {
        TODO("Not yet implemented")
    }

    override fun getAll(callback: (List<Stuff>) -> Unit) {
        executorService.execute {
            var stuffs = stuffDao.getAll().map { stuffDB -> Stuff(stuffDB.name!!) }
            mainThreadHandler.post { callback(stuffs) }
        }
    }

}
