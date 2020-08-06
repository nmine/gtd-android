package be.nmine.gtd.core.domain.project

import be.nmine.gtd.core.domain.project.Project

interface ProjectRepository {
    fun addProject(project: Project)
    fun getProject(projectName: String): Project

}
