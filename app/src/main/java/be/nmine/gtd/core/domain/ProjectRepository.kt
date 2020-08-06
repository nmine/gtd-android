package be.nmine.gtd.core.domain

interface ProjectRepository {
    fun addProject(project: Project)
    fun getProject(projectName: String): Project

}
