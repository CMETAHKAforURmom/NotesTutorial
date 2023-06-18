package com.andernam.notestutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.andernam.notestutorial.feauture_note.data.data_source.NoteDao
import com.andernam.notestutorial.feauture_note.data.repository.NoteRepositoryImpl
import com.andernam.notestutorial.feauture_note.domain.repository.NoteRepository
import com.andernam.notestutorial.feauture_note.domain.use_case.AddNote
import com.andernam.notestutorial.feauture_note.domain.use_case.NotesUseCases
import com.andernam.notestutorial.feauture_note.presentation.add_edit_notes.AddEditNoteScreen
import com.andernam.notestutorial.feauture_note.presentation.notes.NotesScreen
import com.andernam.notestutorial.feauture_note.presentation.utill.Screen
import com.andernam.notestutorial.ui.di.AppModule.provideNoteUseCases
import com.andernam.notestutorial.ui.theme.NotesTutorialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTutorialTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NotesScreen.route
                    ) {
                        composable(Screen.NotesScreen.route) {
                            NotesScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(navController = navController, noteColor = color)
                        }

                    }
                }
            }
        }
    }
}