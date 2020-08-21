/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package be.nmine.gtd.di

import android.content.Context
import androidx.room.Room
import be.nmine.gtd.infrastructure.ApplicationDatabase
import be.nmine.gtd.infrastructure.action.ActionRoomDao
import be.nmine.gtd.infrastructure.basket.BasketRoomDao
import be.nmine.gtd.infrastructure.basket.InboxZeroRepositoryRoom
import be.nmine.gtd.infrastructure.trash.TrashRoomDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ApplicationDatabase {
        return Room.databaseBuilder(
            appContext,
            ApplicationDatabase::class.java,
            "gtd.db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideBasketDao(database: ApplicationDatabase): BasketRoomDao {
        return database.stuffDao()
    }

    @Provides
    fun provideActionDao(database: ApplicationDatabase): ActionRoomDao {
        return database.actionDao()
    }

    @Provides
    fun provideTrashDao(database: ApplicationDatabase): TrashRoomDao {
        return database.trashDao()
    }

    @Provides
    fun provideInboxZeroDao(database: ApplicationDatabase): InboxZeroRepositoryRoom {
        return database.inboxZeroRoom()
    }
}
