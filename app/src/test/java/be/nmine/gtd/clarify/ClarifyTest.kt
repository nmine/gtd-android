package be.nmine.gtd.clarify

import be.nmine.gtd.core.application.CaptureStuffCommand
import be.nmine.gtd.core.application.CaptureStuffHandler
import be.nmine.gtd.core.application.ClarifyStuffHandler
import be.nmine.gtd.core.application.ClarifyStuffToActionCommand
import be.nmine.gtd.core.domain.ActionRepository
import be.nmine.gtd.core.domain.Basket
import be.nmine.gtd.core.domain.Stuff
import be.nmine.gtd.core.infrastructure.ActionRepositoryInMemory
import be.nmine.gtd.core.infrastructure.BasketInMemory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ClarifyTest {
    val basket: Basket = BasketInMemory()
    val actionRepository: ActionRepository = ActionRepositoryInMemory()


    @DisplayName("Given one stuff with name 'Appeller Christelle' is in the basket\n"+
        "When I clarify this Stuff\n"+
         "Then the stuff become and action and is added to the actions list\n")
    @Test
    fun `can clarify and stuff become actionnable`() {
        //Given
        val stuff = addOneStuffInBasket("Appeller Christelle")
        //When
        ClarifyStuffHandler(actionRepository).handle(ClarifyStuffToActionCommand(stuff))
        //Then
        assertEquals(actionRepository.getAction(stuff.name).name, stuff.name)
    }

    @DisplayName(
        """Given one stuff with name 'Faire des pompages tout les jours' is in the basket
            When I clarify this Stuff
            Then the stuff is moved to the Trash""")
    @Test
    fun `can clarify a stuff to move to trash`() {
        //Given
        val stuff = addOneStuffInBasket("Appeller Christelle")
        //When
        ClarifyStuffHandler(actionRepository).handle(ClarifyStuffToActionCommand(stuff))
        //Then
        assertEquals(actionRepository.getAction(stuff.name).name, stuff.name)
    }

    private fun addOneStuffInBasket(stuffName: String):Stuff {
        val stuff = Stuff(stuffName)
        CaptureStuffHandler(basket).handle(CaptureStuffCommand(stuff))
        return stuff
    }
}