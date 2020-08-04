package be.nmine.gtd.core.domain

interface Basket {
    fun saveStuff(stuff: Stuff)
    fun getStuff(stuff: String):Stuff

}
