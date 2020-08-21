package be.nmine.gtd.capture

import be.nmine.gtd.application.capture.captureStuff.CaptureStuffCommand
import be.nmine.gtd.application.capture.captureStuff.CaptureStuffHandler
import be.nmine.gtd.application.capture.getAllStuffs.GetAllStuffHandler
import be.nmine.gtd.application.clarify.ClarifyStuffHandler
import be.nmine.gtd.application.clarify.action.ClarifyStuffToActionCommand
import be.nmine.gtd.domain.action.ActionRepository
import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.domain.basket.Stuff
import be.nmine.gtd.domain.trash.TrashRepository
import be.nmine.gtd.infrastructure.action.ActionRepositoryInMemory
import be.nmine.gtd.infrastructure.basket.BasketInMemory
import be.nmine.gtd.infrastructure.trash.TrashRepositoryInmemory
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class CaptureTest {
    private val basket: Basket = BasketInMemory()
    private val actionRepository: ActionRepository = ActionRepositoryInMemory()
    private val trashRepository: TrashRepository = TrashRepositoryInmemory()

    @DisplayName(
        "Given I'm a user\n" +
                "When the stuff with name'Appeller Christelle'is captured\n" +
                "Then the stuff is is present in the Basket\n"
    )
    @Test
    fun `can create a valid stuff in basket`() = runBlocking {
        val stuff = Stuff("Appeller Christelle")
        CaptureStuffHandler(
            basket
        ).handle(
            CaptureStuffCommand(
                stuff
            )
        )
        //Then
        assertEquals(basket.getStuff(stuff.name).name, stuff.name)
    }


    @DisplayName(
        "Given I'm a user\n" +
                "When I go to the Inbox\n" +
                "Then I should see how many time passes since the last Zero Inbox"
    )
    @Test
    fun `inboxZero should be more recent after clarify last stuff to action`() = runBlocking {
        //Given
        //When
        val stuff = Stuff("Appeller Christelle")
        addOneStuffInBasket(stuff)
        clarifyStuffToAction(stuff)
        //Then
    }

    private suspend fun clarifyStuffToAction(stuff: Stuff) {
        ClarifyStuffHandler(
            basket,
            actionRepository,
            trashRepository
        ).handle(ClarifyStuffToActionCommand(stuff))
    }

    @Test
    @InternalCoroutinesApi
    fun `can get all stuffs`() = runBlocking {
        //Given
        val stuff = Stuff("Appeller Christelle")
        addOneStuffInBasket(stuff)
        //When
        val flow = GetAllStuffHandler(basket)
            .handle()
        //Then
        flow.collect { value: List<Stuff?> ->
            assertEquals(value[0]!!.name, stuff.name)
        }
    }

    private suspend fun addOneStuffInBasket(stuff: Stuff): Stuff {
        CaptureStuffHandler(
            basket
        ).handle(
            CaptureStuffCommand(
                stuff
            )
        )
        return stuff
    }


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