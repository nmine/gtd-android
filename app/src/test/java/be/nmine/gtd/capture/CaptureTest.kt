package be.nmine.gtd.capture

import be.nmine.gtd.StuffDTO
import be.nmine.gtd.core.application.capture.captureStuff.CaptureStuffCommand
import be.nmine.gtd.core.application.capture.captureStuff.CaptureStuffHandler
import be.nmine.gtd.core.application.capture.getAllStuffs.GetAllStuffHandler
import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff
import be.nmine.gtd.core.infrastructure.basket.BasketInMemory
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class CaptureTest {
    val basket: Basket = BasketInMemory()

    @DisplayName("Given I'm a user\n"+
            "When the stuff with name'Appeller Christelle'is captured\n"+
            "Then the stuff is is present in the Basket\n")
    @Test
    fun `can create a valid stuff in basket`()= runBlocking  {
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

//    @InternalCoroutinesApi
//    @Test
//     fun `can get all stuffs`() = runBlocking  {
//        val stuffName = "Appeller Christelle"
//        val flow = GetAllStuffHandler(
//            basket
//        ).handle()
//        //Then
//        flow.take(1).collect { value: List<StuffDTO> ->
//            assertEquals(value[0].name, stuffName)
//        }
//    }


//    Issue between  suspend function and assertThrows https://github.com/junit-team/junit5/pull/1853
//    @DisplayName("Given I'm a user\n"+
//            "When I capture a rule without a name\n"+
//            "Then The stuff is not present in the Basket\n")
//    @Test
//    suspend fun `should_not_be_possible_to_create_invalid_stuff_in_inbox`() {
//        assertThrows(IllegalArgumentException::class.java) {
//            CaptureStuffHandler(
//                basket
//            ).handle(
//                CaptureStuffCommand(
//                    Stuff("")
//                )
//            )
//        }
//    }
}