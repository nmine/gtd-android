package be.nmine.gtd.core.infrastructure

import be.nmine.gtd.core.domain.Project
import be.nmine.gtd.core.domain.ProjectRepository

class ProjectRepositoryInmemory : ProjectRepository {
    private var projects: MutableList<Project> = mutableListOf()

    override fun addProject(project: Project) {
        projects.add(project)
    }

    override fun getProject(projectName: String): Project {
        return projects.filter { project -> project.name == projectName }.first()
    }

}
