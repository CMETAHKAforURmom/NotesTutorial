package com.andernam.notestutorial.ui.di

import android.app.Application
import androidx.room.Room
import com.andernam.notestutorial.feauture_note.data.data_source.NoteDataBase
import com.andernam.notestutorial.feauture_note.data.repository.NoteRepositoryImpl
import com.andernam.notestutorial.feauture_note.domain.repository.NoteRepository
import com.andernam.notestutorial.feauture_note.domain.use_case.AddNote
import com.andernam.notestutorial.feauture_note.domain.use_case.DeleteNote
import com.andernam.notestutorial.feauture_note.domain.use_case.GetNote
import com.andernam.notestutorial.feauture_note.domain.use_case.GetNotes
import com.andernam.notestutorial.feauture_note.domain.use_case.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDataBase{
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDataBase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NotesUseCases{
        return NotesUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}