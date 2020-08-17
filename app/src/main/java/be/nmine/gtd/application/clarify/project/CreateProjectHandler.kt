package be.nmine.gtd.application.clarify.project

import be.nmine.gtd.domain.project.Project
import be.nmine.gtd.domain.project.ProjectRepository

class CreateProjectHandler(val projectRepository: ProjectRepository) {


    fun handle(command: CreateProjectCommand) {
        projectRepository.addProject(Project(command.name))
    }

}
