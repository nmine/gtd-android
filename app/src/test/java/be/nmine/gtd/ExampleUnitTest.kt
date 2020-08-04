package be.nmine.gtd

import be.nmine.gtd.core.application.CaptureStuffCommand
import be.nmine.gtd.core.application.CaptureStuffHandler
import be.nmine.gtd.core.domain.Basket
import be.nmine.gtd.core.domain.Stuff
import be.nmine.gtd.core.infrastructure.BasketInMemory
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val  basket: Basket = BasketInMemory()

    //"Given I'm a user"
    //"When the stuff with name'Appeller Christelle'is captured"
    //"Then the stuff is is present in the Basket"
    @Test
    fun can_create_a_valid_stuff_in_inbox() {
        val stuffName = "Appeller Christelle"
        CaptureStuffHandler(basket).handle(CaptureStuffCommand(Stuff(stuffName)))
        //Then
        assert(basket.getStuff(stuffName).name == stuffName)
    }
}