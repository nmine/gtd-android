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
                "Then a new nextActions 'appeller christelle des que possible' is created\n" +
                "And the actionItem 'appeller christelle' is removed from actionItems"
    )
    fun `can organise a actionItem to nextAction`() = runBlocking {
        //Given
        val action = "Application GTD"
        val nextAction = "appeller christelle des que possible"
        actionRepository.saveAction(Action(action))
        //When
        CreateNextActionsHandler(
            nextActionRepository,
            actionRepository
        ).handle(
            CreateNextActionCommand(
                nextAction = nextAction,
                actionItem = action
            )
        )
        //Then
        assertThatActionItemsIsEmpty()
        assertEquals(nextActionRepository.getNextAction(nextAction).name, nextAction)
    }

    @Test
    @DisplayName(
        "# Story : As a User I want to delete the NextAction so That I can correct a error I made\n" +
                "Given one nextActions with name 'appeller christelle' is in the nextActions\n" +
                "And this nextAction is not dereded nor delegated\n" +
                "When I delete the nextActions\n" +
                "Then the nextAction 'appeller christelle' is not present in the list nextAction any more"
    )
    fun `can delete a nextAction that is not delegated nor defered`() = runBlocking {
        //Given
        val action = "appeller christelle"
        val nextAction = NextAction(action)
        nextActionRepository.save(nextAction)
        //When
        nextActionRepository.remove(nextAction)
        //Then
        nextActionRepository.getAll().collect {
            assertTrue(it.isEmpty())
        }
    }

    @Test
    fun `can get all nextAction`() = runBlocking {
        //Given
        val nextAction = "Application GTD"
        val actionItem = "Application GTD action"
        CreateNextActionsHandler(
            nextActionRepository,
            actionRepository
        ).handle(
            CreateNextActionCommand(
                nextAction = nextAction,
                actionItem = actionItem
            )
        )
        //When
        val allNextActions = nextActionRepository.getAll()
        //Then
        assertEquals(allNextActions.first()[0]?.name, nextAction)
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