package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test.ui.theme.MainViewModel
import com.example.test.ui.theme.screens.DetailScreen
import com.example.test.ui.theme.screens.ListScreen

@ExperimentalUnitApi
class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            val viewModel: MainViewModel = viewModel()

            NavHost(navController = navController, startDestination = "list") {
                composable("list") { ListScreen(viewModel, navController) }
                composable("detail/{postId}") { DetailScreen(viewModel, navController, it.arguments?.getString("postId")) }
            }
        }
    }
}
