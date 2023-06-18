package com.andernam.notestutorial.feauture_note.presentation.add_edit_notes

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun AddEditNoteScreen(
    navController: NavController,
    noteColor: Int,
    viewModel: AddEditNoteViewModel = hiltViewModel()
) {
    val titleState = viewModel.noteTitle.value
    val contentState : NoteTextFieldState = viewModel.noteContent.value

    val scaffoldState = rememberScaffoldState()
}