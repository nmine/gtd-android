package be.nmine.gtd.domain.project

interface ProjectRepository {
    fun addProject(project: Project)
    fun getProject(projectName: String): Project

}
