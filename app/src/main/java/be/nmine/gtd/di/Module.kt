package be.nmine.gtd.di

import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.infrastructure.basket.BasketRoom
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

}
