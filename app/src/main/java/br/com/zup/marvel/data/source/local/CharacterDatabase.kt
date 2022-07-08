package br.com.zup.marvel.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.zup.marvel.data.source.local.dao.CharacterDAO

@Database(entities = [Character::class], version = 1)
@TypeConverters(Converters::class)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDAO

    companion object {
        @Volatile
        private var INSTANCE: CharacterDatabase? = null

        fun getDatabase(context: Context): CharacterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CharacterDatabase::class.java,
                    "character_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}