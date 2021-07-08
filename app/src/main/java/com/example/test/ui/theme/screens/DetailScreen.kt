package com.example.test.ui.theme.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.test.R
import com.example.test.ui.theme.MainViewModel
import com.example.test.ui.theme.TestTheme
import com.example.test.ui.theme.views.PostModel

@ExperimentalFoundationApi
@Composable
fun DetailScreen(viewModel: MainViewModel, navController: NavHostController, postId: String?) {
    val post = viewModel.posts.first { post -> post.id.toString() == postId }

    DetailScreenContent(post = post)
}

@ExperimentalFoundationApi
@Composable
fun DetailScreenContent(post: PostModel) {
    TestTheme {
        Scaffold(
            topBar = {
                TopAppBar {
                    Text(post.title)
                }
            }
        ) {
            Column {
                // Experimental, fills screen with all cells in one row
                LazyVerticalGrid(cells = GridCells.Fixed(2)) {
                    items(count = post.imagesCount) {
                        Image(
                            painterResource(id = R.drawable.placeholder),
                            contentDescription = "",
                            modifier = Modifier
                                .height(150.dp)
                                .width(150.dp),
                            contentScale = ContentScale.Crop,
                        )
                    }
                }

                Column(modifier = Modifier.padding(8.dp)) {
                    Text("Post ID", style = TextStyle(color = Color.DarkGray, fontWeight = FontWeight.Bold))
                    Text(post.id.toString())
                }

                Column(modifier = Modifier.padding(8.dp)) {
                    Text("Post Subtitle", style = TextStyle(color = Color.DarkGray, fontWeight = FontWeight.Bold))
                    Text(post.subtitle)
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(device = Devices.PIXEL_4)
@Composable
fun ContentPreview() {
    DetailScreenContent(post = PostModel(imagesCount = 5))
}