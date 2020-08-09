package be.nmine.gtd.di

import be.nmine.gtd.core.application.capture.CaptureStuffHandler
import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.infrastructure.BasketInMemory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
abstract class LoggingDatabaseModule {

    @Singleton
    @Binds
    abstract fun bindBasket(impl: BasketInMemory): Basket

    @Singleton
    @Binds
    abstract fun binCaptureStuffHandler(impl: CaptureStuffHandler): CaptureStuffHandler
}
