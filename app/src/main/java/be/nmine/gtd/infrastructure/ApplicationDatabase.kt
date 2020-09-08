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

package be.nmine.gtd.infrastructure

import androidx.room.Database
import androidx.room.RoomDatabase
import be.nmine.gtd.infrastructure.action.ActionRoom
import be.nmine.gtd.infrastructure.action.ActionRoomDao
import be.nmine.gtd.infrastructure.basket.BasketRoomDao
import be.nmine.gtd.infrastructure.basket.InboxZeroRepositoryRoom
import be.nmine.gtd.infrastructure.basket.InboxZeroRoom
import be.nmine.gtd.infrastructure.basket.StuffRoom
import be.nmine.gtd.infrastructure.nextAction.NextActionRoom
import be.nmine.gtd.infrastructure.nextAction.NextActionRoomDao
import be.nmine.gtd.infrastructure.trash.TrashRoom
import be.nmine.gtd.infrastructure.trash.TrashRoomDao

@Database(
    entities = [StuffRoom::class, ActionRoom::class, TrashRoom::class, InboxZeroRoom::class, NextActionRoom::class],
    version = 5, exportSchema = false
)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun stuffDao(): BasketRoomDao
    abstract fun actionDao(): ActionRoomDao
    abstract fun trashDao(): TrashRoomDao
    abstract fun nextActionDao(): NextActionRoomDao
    abstract fun inboxZeroRoom(): InboxZeroRepositoryRoom
}
