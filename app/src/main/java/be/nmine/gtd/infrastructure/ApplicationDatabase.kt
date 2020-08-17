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
import be.nmine.gtd.infrastructure.basket.StuffRoom

/**
 * SQLite Database for storing the logs.
 */
@Database(entities = [StuffRoom::class, ActionRoom::class], version = 2, exportSchema = false)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun stuffDao(): BasketRoomDao
    abstract fun actionDao(): ActionRoomDao
}
