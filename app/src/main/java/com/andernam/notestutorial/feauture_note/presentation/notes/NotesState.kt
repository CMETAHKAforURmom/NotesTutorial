package com.andernam.notestutorial.feauture_note.presentation.notes

import com.andernam.notestutorial.feauture_note.domain.model.Note
import com.andernam.notestutorial.feauture_note.domain.utill.NoteOrder
import com.andernam.notestutorial.feauture_note.domain.utill.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionVisible: Boolean = false
)
