package be.nmine.gtd.capture

import be.nmine.gtd.core.application.capture.captureStuff.CaptureStuffCommand
import be.nmine.gtd.core.application.capture.captureStuff.CaptureStuffHandler
import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff
import be.nmine.gtd.core.infrastructure.BasketInMemory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CaptureTest {
    val basket: Basket = BasketInMemory()

    @DisplayName("Given I'm a user\n"+
            "When the stuff with name'Appeller Christelle'is captured\n"+
            "Then the stuff is is present in the Basket\n")
    @Test
    fun `can create a valid stuff in basket`() {
        val stuffName = "Appeller Christelle"
        CaptureStuffHandler(
            basket
        ).handle(
            CaptureStuffCommand(
                Stuff(stuffName)
            )
        )
        //Then
        assertEquals(basket.getStuff(stuffName).name, stuffName)
    }

    @DisplayName("Given I'm a user\n"+
            "When I capture a rule without a name\n"+
            "Then The stuff is not present in the Basket\n")
    @Test
    fun `should_not_be_possible_to_create_invalid_stuff_in_inbox`() {
        assertThrows(IllegalArgumentException::class.java) {
            CaptureStuffHandler(
                basket
            ).handle(
                CaptureStuffCommand(
                    Stuff("")
                )
            )
        }
    }
}