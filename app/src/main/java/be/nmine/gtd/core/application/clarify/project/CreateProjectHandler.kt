package be.nmine.gtd.core.application.clarify.project

import be.nmine.gtd.core.domain.project.Project
import be.nmine.gtd.core.domain.project.ProjectRepository

class CreateProjectHandler(val projectRepository: ProjectRepository) {


    fun handle(command: CreateProjectCommand) {
        projectRepository.addProject(
            Project(
                command.name
            )
        )
    }

}
