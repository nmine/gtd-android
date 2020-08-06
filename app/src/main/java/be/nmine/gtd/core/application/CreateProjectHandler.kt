package be.nmine.gtd.core.application

import be.nmine.gtd.core.domain.Project
import be.nmine.gtd.core.domain.ProjectRepository

class CreateProjectHandler(val projectRepository: ProjectRepository) {


    fun handle(command: CreateProjectCommand) {
        projectRepository.addProject(Project(command.name))
    }

}
