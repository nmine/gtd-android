package be.nmine.gtd.infrastructure.project

import be.nmine.gtd.domain.project.Project
import be.nmine.gtd.domain.project.ProjectRepository

class ProjectRepositoryInmemory :
    ProjectRepository {
    private var projects: MutableList<Project> = mutableListOf()

    override fun addProject(project: Project) {
        projects.add(project)
    }

    override fun getProject(projectName: String): Project {
        return projects.filter { project -> project.name == projectName }.first()
    }

}
