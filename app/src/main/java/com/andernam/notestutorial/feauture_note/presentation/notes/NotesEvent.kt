package com.andernam.notestutorial.feauture_note.presentation.notes

import com.andernam.notestutorial.feauture_note.domain.model.Note
import com.andernam.notestutorial.feauture_note.domain.utill.NoteOrder

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
