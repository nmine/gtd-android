package be.nmine.gtd.domain.stuff

import kotlin.IllegalArgumentException

class Stuff(val name: String) {
    init {
        if(name.isEmpty())
            throw IllegalArgumentException("Stuff name cannot be empty")
    }

}
