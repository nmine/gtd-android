package be.nmine.gtd.clarify

import be.nmine.gtd.core.application.capture.captureStuff.CaptureStuffCommand
import be.nmine.gtd.core.application.capture.captureStuff.CaptureStuffHandler
import be.nmine.gtd.core.application.clarify.ClarifyStuffHandler
import be.nmine.gtd.core.application.clarify.action.ClarifyStuffToActionCommand
import be.nmine.gtd.core.application.clarify.project.CreateProjectCommand
import be.nmine.gtd.core.application.clarify.project.CreateProjectHandler
import be.nmine.gtd.core.application.clarify.trash.ClarifyStuffToMoveToTrash
import be.nmine.gtd.core.domain.action.ActionRepository
import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.project.ProjectRepository
import be.nmine.gtd.core.domain.stuff.Stuff
import be.nmine.gtd.core.domain.trash.TrashRepository
import be.nmine.gtd.core.infrastructure.action.ActionRepositoryInMemory
import be.nmine.gtd.core.infrastructure.basket.BasketInMemory
import be.nmine.gtd.core.infrastructure.project.ProjectRepositoryInmemory
import be.nmine.gtd.core.infrastructure.trash.TrashRepositoryInmemory
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class ClarifyTest {
    val basket: Basket = BasketInMemory()
    val actionRepository: ActionRepository =
        ActionRepositoryInMemory()
    val trashRepository : TrashRepository =
        TrashRepositoryInmemory()
    val projectRepository : ProjectRepository =
        ProjectRepositoryInmemory()


    @DisplayName("Given one stuff with name 'Appeller Christelle' is in the basket\n"+
        "When I clarify this Stuff\n"+
         "Then the stuff become and action and is added to the actions list\n")
    @Test
    fun `can clarify and stuff become actionnable`()  = runBlocking {
        //Given
        val stuff = addOneStuffInBasket("Appeller Christelle")
        //When
        ClarifyStuffHandler(
            actionRepository,
            trashRepository
        ).handle(
            ClarifyStuffToActionCommand(
                stuff
            )
        )
        //Then
        assertEquals(actionRepository.getAction(stuff.name).name, stuff.name)
    }

    @DisplayName(
        """Given one stuff with name 'Faire des pompages tout les jours' is in the basket
            When I clarify this Stuff
            Then the stuff is moved to the Trash""")
    @Test
     fun `can clarify a stuff to move to trash`() = runBlocking {
        //Given
        val stuff = addOneStuffInBasket("Appeller Christelle")
        //When
        ClarifyStuffHandler(
            actionRepository,
            trashRepository
        ).handle(
            ClarifyStuffToMoveToTrash(
                stuff
            )
        )
        //Then
        assertEquals(trashRepository.getStuff(stuff.name).name, stuff.name)
    }

    @Test
    @DisplayName(
        "Given one stuff with name 'étudier tout les jours une heure' is in the basket" +
                "When I clarify this Stuff" +
                "Then a new project 'passer un diplôme' is created" +
                "And an action 'étudier tout les jours une heure' is created and added to the action list"
    )
    fun `can clarify a stuff to project`() = runBlocking {
        //Given
        val projectName = "Application GTD"
        //When
        CreateProjectHandler(
            projectRepository
        ).handle(
            CreateProjectCommand(
                projectName
            )
        )
        //Then
        assertEquals(projectRepository.getProject(projectName).name, projectName)
    }

    private suspend fun addOneStuffInBasket(stuffName: String): Stuff {
        val stuff = Stuff(stuffName)
        CaptureStuffHandler(
            basket
        ).handle(
            CaptureStuffCommand(
                stuff
            )
        )
        return stuff
    }
}