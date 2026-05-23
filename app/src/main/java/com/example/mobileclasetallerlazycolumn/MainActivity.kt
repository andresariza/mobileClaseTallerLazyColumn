package com.example.mobileclasetallerlazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mobileclasetallerlazycolumn.model.Post

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var post = Post(1, "", "", "", 1, "", false)

            var replica = post.copy(isLiked = false)
            println(replica.id)

            val posts = listOf(

                Post(
                    id = 1,
                    username = "Andres Ariza",
                    profileImageUrl = "https://i.pravatar.cc/150?img=1",
                    imageUrl = "https://picsum.photos/id/1011/600/400",
                    likes = 245,
                    caption = "Disfrutando una tarde de café ☕",
                    isLiked = true
                ),

                Post(
                    id = 2,
                    username = "Maria Gomez",
                    profileImageUrl = "https://i.pravatar.cc/150?img=5",
                    imageUrl = "https://picsum.photos/id/1025/600/400",
                    likes = 892,
                    caption = "Un hermoso paisaje natural 🌿",
                    isLiked = false
                ),

                Post(
                    id = 3,
                    username = "Carlos Perez",
                    profileImageUrl = "https://i.pravatar.cc/150?img=8",
                    imageUrl = "https://picsum.photos/id/1040/600/400",
                    likes = 120,
                    caption = "Trabajando en nuevos proyectos 💻",
                    isLiked = true
                ),

                Post(
                    id = 4,
                    username = "Laura Torres",
                    profileImageUrl = "https://i.pravatar.cc/150?img=12",
                    imageUrl = "https://picsum.photos/id/1062/600/400",
                    likes = 431,
                    caption = "Atardecer increíble 🌅",
                    isLiked = false
                ),

                Post(
                    id = 5,
                    username = "Juan Martinez",
                    profileImageUrl = "https://i.pravatar.cc/150?img=15",
                    imageUrl = "https://picsum.photos/id/1074/600/400",
                    likes = 999,
                    caption = "Viajar siempre vale la pena ✈️",
                    isLiked = true
                ),
                Post(
                    id = 6,
                    username = "Sofia Ramirez",
                    profileImageUrl = "https://i.pravatar.cc/150?img=20",
                    imageUrl = "https://picsum.photos/id/1084/600/400",
                    likes = 512,
                    caption = "Día perfecto para programar y escuchar música 🎧",
                    isLiked = false
                ),

                Post(
                    id = 7,
                    username = "Daniel Castro",
                    profileImageUrl = "https://i.pravatar.cc/150?img=25",
                    imageUrl = "https://picsum.photos/id/1080/600/400",
                    likes = 134,
                    caption = "Explorando nuevas tecnologías móviles 📱",
                    isLiked = true
                ),

                Post(
                    id = 8,
                    username = "Valentina Lopez",
                    profileImageUrl = "https://i.pravatar.cc/150?img=30",
                    imageUrl = "https://picsum.photos/id/1069/600/400",
                    likes = 742,
                    caption = "Nada mejor que una caminata en la naturaleza 🌲",
                    isLiked = true
                ),

                Post(
                    id = 9,
                    username = "Felipe Hernandez",
                    profileImageUrl = "https://i.pravatar.cc/150?img=35",
                    imageUrl = "https://picsum.photos/id/1050/600/400",
                    likes = 88,
                    caption = "Modo estudio activado 📚",
                    isLiked = false
                ),

                Post(
                    id = 10,
                    username = "Camila Rojas",
                    profileImageUrl = "https://i.pravatar.cc/150?img=40",
                    imageUrl = "https://picsum.photos/id/1037/600/400",
                    likes = 1560,
                    caption = "Una vista espectacular desde la montaña ⛰️",
                    isLiked = true
                )
            )

            BasicFeedList(posts)
        }
    }
}

@Composable

fun BasicFeedList(posts: List<Post>) {
    // TODO: usa LazyColumn con fillMaxSize, contentPadding vertical de 8.dp
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp),
        // TODO: ¿qué parámetro controla el espacio entre ítems?
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        //3. Reto: Dentro del bloque items { },agrega unitem { } antes de los posts que muestre un Text("-
        //Inicio del Feed -"). ¿En qué posición aparece en pantalla? respuesta... aparece antes de todo el listado
        item {
            Text("- Inicio del Feed -")
        }
        // items() itera sobre la lista de forma lazy
        items(
            items = posts,
            // TODO: completa el key para identificar cada ítem por su id
            key = { post -> post.id }
        ) { post ->
            PostCard(post = post)
        }

    }
}

// Variante con índice - completa los parámetros del lambda
@Composable
fun FeedWithIndex(posts: List<Post>) {
    LazyColumn {

        // TODO: usa itemsIndexed en lugar de items para obtener el índice
        itemsIndexed(posts) { index, post ->
            Text("Post #$index: ${post.username}")
        }
    }
}


@Composable
fun PostCard(
    post: Post,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // HEADER
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = post.username,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Opciones"
                    )
                }
            }

            // ACCIONES
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {


                IconButton(onClick = {}) {
                    Icon(
                        imageVector = if (post.isLiked)
                            Icons.Default.Favorite
                        else
                            Icons.Default.FavoriteBorder,
                        contentDescription = "Like",
                        tint = if (post.isLiked)
                            MaterialTheme.colorScheme.error
                        else
                            MaterialTheme.colorScheme.onSurface
                    )

                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.ChatBubbleOutline,
                            contentDescription = "Comentar"
                        )
                    }

                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.Send,
                            contentDescription = "Compartir"
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.BookmarkBorder,
                            contentDescription = "Guardar"
                        )
                    }
                }
            }

            // LIKES
            Text(
                text = "${post.likes} likes",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            // CAPTION
            Text(
                text = "${post.username} ${post.caption}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}