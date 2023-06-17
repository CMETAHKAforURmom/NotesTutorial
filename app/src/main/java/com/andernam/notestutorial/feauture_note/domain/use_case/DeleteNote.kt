package com.andernam.notestutorial.feauture_note.domain.use_case

import com.andernam.notestutorial.feauture_note.domain.model.Note
import com.andernam.notestutorial.feauture_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }

}