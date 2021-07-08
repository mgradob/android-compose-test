package com.example.test.ui.theme.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.test.ui.theme.MainViewModel
import com.example.test.ui.theme.Teal200
import com.example.test.ui.theme.TestTheme
import com.example.test.ui.theme.views.GreetingView
import com.example.test.ui.theme.views.PostModel
import com.example.test.ui.theme.views.PostView

@ExperimentalUnitApi
@Composable
fun ListScreen(viewModel: MainViewModel, navController: NavController) {
    ListScreenContent(
        posts = viewModel.posts,
        onFabClick = { viewModel.createRandomPost() },
        onPostClick = { navController.navigate(it) },
    )
}

@ExperimentalUnitApi
@Composable
fun ListScreenContent(
    posts: List<PostModel>,
    onFabClick: () -> Unit,
    onPostClick: (screen: String) -> Unit
) {
    TestTheme {
        Scaffold(
            topBar = { TopBar() },
            floatingActionButton = {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add a post")
                }
            }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                when {
                    posts.isEmpty() -> Column {
                        GreetingView()

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(text = "No posts yet :(")
                        }
                    }

                    else -> PostsList(posts = posts, onPostClick = onPostClick)
                }
            }
        }
    }
}

@Composable
fun TopBar() = TopAppBar(
    title = { Text(text = "Jetpack Compose") },
    elevation = 3.dp
)

@ExperimentalUnitApi
@Composable
fun PostsList(posts: List<PostModel>, onPostClick: (screen: String) -> Unit) = LazyColumn {
    item {
        GreetingView()
    }

    items(
        count = posts.size,
        key = { posts[it].id }
    ) {
        PostView(postModel = posts[it]) { post -> onPostClick("detail/${post.id}") }
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", color = Teal200)
}

@ExperimentalUnitApi
@Preview(device = Devices.PIXEL_4)
@Composable
fun PreviewEmptyContent() {
    ListScreenContent(posts = listOf(), onFabClick = {}, onPostClick = {})
}

@ExperimentalUnitApi
@Preview(device = Devices.PIXEL_4)
@Composable
fun PreviewWithListContent() {
    ListScreenContent(posts = listOf(PostModel(), PostModel()), onFabClick = {}, onPostClick = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    TestTheme {
        Greeting("Preview")
    }
}

@Preview
@Composable
fun PreviewGreeting2() {
    TestTheme {
        Greeting("Test")
    }
}