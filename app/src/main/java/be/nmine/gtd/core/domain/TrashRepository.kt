package be.nmine.gtd.core.domain

interface TrashRepository {
    fun getStuff(name:String):Stuff
    fun addStuff(stuff: Stuff)
}
