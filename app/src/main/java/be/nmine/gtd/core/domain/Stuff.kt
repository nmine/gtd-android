package be.nmine.gtd.core.domain

import kotlin.IllegalArgumentException

class Stuff(val name: String) {
    init {
        if(name.isEmpty())
            throw IllegalArgumentException("Stuff name cannot be empty")
    }

}
