package id.ac.unpas.mynote

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.mynote.dao.NoteDao
import id.ac.unpas.mynote.models.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
