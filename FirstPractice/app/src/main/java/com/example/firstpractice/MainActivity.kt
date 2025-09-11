package com.example.firstpractice
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.firstpractice.DataExample
import com.example.firstpractice.ui.theme.FirstPracticeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstPracticeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    DogderActivity(
                        users = DataExample.UsersList(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DogderActivity(users: List<User> = emptyList(), modifier: Modifier = Modifier) {
    var currentUserIndex by remember { mutableStateOf(1) }
    var presioned by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        if (users.isNotEmpty()) {
            HeaderActivity(users[0].perfilPicture)

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                if (currentUserIndex < users.size) {
                    val cardsToShow = minOf(3, users.size - currentUserIndex)
                    for (i in (cardsToShow - 1) downTo 0) {
                        val userIndex = currentUserIndex + i
                        if (userIndex < users.size) {
                            val user = users[userIndex]
                            val post = user.post
                            if (i == 0) {
                                DogderCardContent(user = user, post = post)
                            } else {
                                BackgroundCard(
                                    user = user,
                                    post = post,
                                    offset = i,
                                    modifier = Modifier
                                        .fillMaxWidth(0.9f - (i * 0.02f))
                                        .fillMaxSize(0.85f - (i * 0.02f))
                                )
                            }
                        }
                    }
                }
            }
            ActionButtons(
                onDislike = {
                    if (currentUserIndex < users.size - 1) {
                        currentUserIndex++
                        presioned = false
                    }
                },
                onLike = {
                    val currentPost = users[currentUserIndex].post
                    val userIds = currentPost.usersLiked
                    val intent = Intent(context, SecundActivity::class.java).apply {
                        putStringArrayListExtra("userIds", ArrayList(userIds))
                    }
                    context.startActivity(intent)
                },
                onSuperLike = {
                    presioned = !presioned
                    SumLikes(users.get(currentUserIndex), presioned)
                    if(presioned){
                    users.get(currentUserIndex).post.usersLiked.add(users.get(0).id)
                    }else{
                        users.get(currentUserIndex).post.usersLiked.remove(users.get(0).id)
                    }
                },
                heartImage = if (presioned) R.drawable.heart_like else R.drawable.heart,
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }
    }
}



@Composable
fun BackgroundCard(
    user: User,
    post: Post?,
    offset: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .offset(y = (offset * 10).dp)
            .graphicsLayer {
                alpha = 1f - (offset * 0.1f)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = (4 - offset).dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        DogderCardContent(user = user, post = post)
    }
}

@Composable
fun DogderCardContent(
    user: User,
    post: Post?
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            if (post != null && post.images.isNotEmpty()) {
                PostPhotosCarousel(post)
            } else {

                AsyncImage(
                    model = user.perfilPicture,
                    contentDescription = user.username,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.breake_bone),
                    error = painterResource(R.drawable.breake_bone)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.7f)
                            )
                        )
                    )
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = user.username,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    if (post != null) {
                        Text(
                            text = "${post.likes} likes",
                            fontSize = 16.sp,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PostPhotosCarousel(post: Post) {
    if (post.images.isNotEmpty()) {
        var currentImageIndex by remember { mutableStateOf(0) }
        val pagerState = rememberPagerState(pageCount = { post.images.size })

        LaunchedEffect(pagerState.currentPage) {
            currentImageIndex = pagerState.currentPage
        }

        Box(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                AsyncImage(
                    model = post.images[page],
                    contentDescription = "Post Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.breake_bone),
                    error = painterResource(R.drawable.breake_bone)
                )
            }
            if (post.images.size > 1) {
                Row(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(post.images.size) { index ->
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .height(4.dp)
                                .fillMaxWidth(1f / post.images.size - 0.02f)
                                .background(
                                    color = if (index == currentImageIndex) {
                                        Color.White
                                    } else {
                                        Color.White.copy(alpha = 0.3f)
                                    },
                                    shape = RoundedCornerShape(2.dp)
                                )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ActionButtons(
    onDislike: () -> Unit,
    onLike: () -> Unit,
    onSuperLike: () -> Unit,
    heartImage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onDislike,
            modifier = Modifier
                .size(60.dp)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(R.drawable.cat),
                contentDescription = "Dislike",
                modifier = Modifier.size(35.dp)
            )
        }

        IconButton(
            onClick = onSuperLike,
            modifier = Modifier
                .size(50.dp)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(heartImage),
                contentDescription = "Super Like",
                modifier = Modifier.size(25.dp)
            )
        }

        IconButton(
            onClick = onLike,
            modifier = Modifier
                .size(60.dp)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(R.drawable.bone),
                contentDescription = "Like",
                modifier = Modifier.size(35.dp)
            )
        }
    }
}

@Composable
fun HeaderActivity(perfilPicture: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFFF005C),
                        Color(0xFFFF7B00)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.padding(horizontal = 50.dp))
        Image(
            painter = painterResource(R.drawable.breake_bone),
            contentDescription = "app logo",
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(
            text = "Dogder",
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.weight(1f),
            color = Color.White
        )

        AsyncImage(
            model = perfilPicture,
            contentDescription = "Profile Photo",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.breake_bone)
        )
    }
}

fun SumLikes(user: User, presioned: Boolean) {
    if (presioned) {
        user.post.likes++
    }else{
        user.post.likes--
    }

}


// Preview Functions
@Preview(showBackground = true)
@Composable
fun DogderTinderPreview() {
    val fakeUsers = listOf(
        User(
            "1",
            "Golden Retriever",

                Post(
                    "1",
                    true,
                    234,
                    listOf("https://picsum.photos/400/600"),
                    mutableListOf()

            ),
            "golden@gmail.com",
            "https://picsum.photos/200"
        ),
        User(
            "2",
            "Husky Siberiano",

                Post(
                    "2",
                    true,
                    567,
                    listOf("https://picsum.photos/401/601", "https://picsum.photos/402/602"),
                    mutableListOf()

            ),
            "husky@gmail.com",
            "https://picsum.photos/201"
        )
    )

    FirstPracticeTheme {
        DogderActivity(users = fakeUsers)
    }
}


@Preview
@Composable
fun ActionButtonsPreview() {
    FirstPracticeTheme {
        ActionButtons(
            onDislike = {},
            onLike = {},
            onSuperLike = {},
            heartImage = R.drawable.heart
        )
    }
}