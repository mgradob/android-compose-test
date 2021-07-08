package com.example.test.ui.theme.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.test.R
import java.util.*
import kotlin.random.Random

class PostModel(
    val id: UUID = UUID.randomUUID(),
    val title: String = "This is a post title",
    val subtitle: String = "This is a post subtitle",
    val imagesCount: Int = Random.nextInt(1, 6)
)

@ExperimentalUnitApi
@Composable
fun PostView(postModel: PostModel, onClick: (PostModel) -> Unit) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .defaultMinSize(250.dp, 200.dp)
            .fillMaxWidth()
            .clickable { onClick.invoke(postModel) }
    ) {
        Column {
            LazyRow(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10.dp))
            ) {
                items(postModel.imagesCount) {
                    Image(
                        painterResource(id = R.drawable.placeholder),
                        contentDescription = "",
                        modifier = Modifier
                            .height(150.dp)
                            .defaultMinSize(250.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                    )
                }
            }

            Text(
                text = postModel.title,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                style = TextStyle(
                    fontSize = TextUnit(24f, type = TextUnitType.Sp),
                    fontWeight = FontWeight.Bold,
                )
            )

            Text(
                text = postModel.subtitle,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                maxLines = 2
            )
        }
    }
}

@ExperimentalUnitApi
@Preview
@Composable
fun PostViewPreview() {
    PostView(PostModel()) {}
}