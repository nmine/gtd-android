package be.nmine.gtd.organise

import be.nmine.gtd.application.clarify.project.CreateProjectCommand
import be.nmine.gtd.application.clarify.project.CreateProjectHandler
import be.nmine.gtd.application.organise.createnextaction.CreateNextActionCommand
import be.nmine.gtd.application.organise.createnextaction.CreateNextActionsHandler
import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.domain.basket.Stuff
import be.nmine.gtd.domain.nextaction.NextAction
import be.nmine.gtd.domain.nextaction.NextActionRepository
import be.nmine.gtd.domain.project.ProjectRepository
import be.nmine.gtd.infrastructure.action.ActionRepositoryInMemory
import be.nmine.gtd.infrastructure.basket.BasketInMemory
import be.nmine.gtd.infrastructure.nextAction.NextActionRepositoryInMemory
import be.nmine.gtd.infrastructure.project.ProjectRepositoryInmemory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class OrganiseTest {
    private val basket: Basket = BasketInMemory()
    private val projectRepository: ProjectRepository = ProjectRepositoryInmemory()
    private val nextActionRepository: NextActionRepository = NextActionRepositoryInMemory()
    private val actionRepository: ActionRepository = ActionRepositoryInMemory()


    @Test
    @DisplayName(
        "Given one stuff with name 'étudier tout les jours une heure' is in the basket" +
                "When I clarify this Stuff" +
                "Then a new project 'passer un diplôme' is created" +
                "And the Stuff become an action 'étudier tout les jours une heure' and added to the action list"
    )
    fun `can organise a actionItem to project`() = runBlocking {
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
        assertThatBasketIsEmpty()
        assertEquals(projectRepository.getProject(projectName).name, projectName)
    }


    @Test
    @DisplayName(
        "Given one actionItem with name 'appeller christelle' is in the actionItems\n" +
                "When I organise my actionsItems\n" +
                "AND I create a new nextACtions from this actionItem with name 'appeller christelle'\n" +
                "Then a new nextActions 'appeller christelle' is created\n" +
                "And the actionItem 'appeller christelle' is removed from actionItems"
    )
    fun `can organise a actionItem to nextAction`() = runBlocking {
        //Given
        val action = Action("Application GTD")
        //When
        CreateNextActionsHandler(
            nextActionRepository,
            actionRepository
        ).handle(
            CreateNextActionCommand(
                action.name
            )
        )
        //Then
        assertThatActionItemsIsEmpty()
        assertEquals(nextActionRepository.getNextAction(action.name).name, action.name)
    }

    @Test
    fun `can get all nextAction`() = runBlocking {
        //Given
        val nextAction = NextAction("Application GTD")
        CreateNextActionsHandler(
            nextActionRepository,
            actionRepository
        ).handle(
            CreateNextActionCommand(
                nextAction.name
            )
        )
        //When
        val allNextACtions = nextActionRepository.getAll()
        //Then
        assertEquals(allNextACtions.first().get(0)?.name, nextAction.name)
    }

    private suspend fun assertThatActionItemsIsEmpty() {
        actionRepository.getAll().collect {
            assertTrue(it.isEmpty())
        }
    }

    private suspend fun assertThatBasketIsEmpty() {
        basket.getAll().collect { stuffs: List<Stuff?> ->
            assertTrue(stuffs.isEmpty())
        }
    }
}