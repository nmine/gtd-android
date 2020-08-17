package be.nmine.gtd.di

import be.nmine.gtd.domain.action.ActionRepository
import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.infrastructure.action.ActionRepositoryRoom
import be.nmine.gtd.infrastructure.action.ActionRoomDao
import be.nmine.gtd.infrastructure.basket.BasketRoom
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
abstract class Module {

    @Binds
    @Singleton
    abstract fun bindBasket(impl: BasketRoom): Basket

    @Binds
    @Singleton
    abstract fun bindActionRepository(impl: ActionRepositoryRoom): ActionRepository

}
