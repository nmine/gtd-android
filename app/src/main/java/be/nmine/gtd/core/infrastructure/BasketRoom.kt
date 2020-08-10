//package be.nmine.gtd.core.infrastructure
//
//import be.nmine.gtd.core.domain.basket.Basket
//import be.nmine.gtd.core.domain.stuff.Stuff
//import javax.inject.Inject
//
//class BasketRoom @Inject constructor(private val stuffDao: StuffDao): Basket {
//
//
//    override fun saveStuff(stuff: Stuff) {
//        var stuff:be.nmine.gtd.core.infrastructure.Stuff = be.nmine.gtd.core.infrastructure.Stuff(name="toto")
//        stuffDao.insertAll(stuff)
//    }
//
//    override fun getStuff(stuff: String): Stuff {
//        return stuffDao.getAll().filter { listStuff -> listStuff.name == stuff }
//            .map { stuff -> Stuff(stuff.name!!) }.first()
//    }
//
//    override fun getAll(callback: (List<Stuff>) -> Unit) {
//        return stuffDao.getAll().map { stuff -> Stuff(stuff.name!!) }
//    }
//
//}
