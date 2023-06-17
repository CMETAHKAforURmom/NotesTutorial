package com.andernam.notestutorial.di

import android.app.Application
import androidx.room.Room
import com.andernam.notestutorial.feauture_note.data.data_source.NoteDataBase
import com.andernam.notestutorial.feauture_note.data.repository.NoteRepositoryImpl
import com.andernam.notestutorial.feauture_note.domain.repository.NoteRepository
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
}