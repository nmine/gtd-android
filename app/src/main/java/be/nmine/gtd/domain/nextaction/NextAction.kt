package be.nmine.gtd.domain.nextaction

class NextAction(val name: String) {
    init {
        if(name.isEmpty())
            throw IllegalArgumentException("NextAction name cannot be empty")
    }

}
