package com.example.practicalistas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalistas.ui.theme.PracticaListasTheme
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaListasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    contactList(modifier = Modifier.padding(innerPadding))
                    //MessageList(modifier = Modifier.padding(innerPadding))
                }
                }
            }
        }
    }

@Composable
fun contactList(modifier: Modifier = Modifier) {
    val contacts = getContactList()
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp), modifier = Modifier.fillMaxWidth())
    {
        items(contacts) {it ->
            ContactItem(it)
            HorizontalDivider(thickness = 1.dp)
        }
    }
}

@Composable
fun ContactItem(contact: Contact) {
    Spacer(modifier = Modifier.size(8.dp))
    Row {
        AsyncImage(
            model = contact.image,
            contentDescription = "Perfil Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Column {
            Text(text = contact.name + " " + contact.lastName, modifier = Modifier.padding(16.dp))
            Text(text = contact.phone, modifier = Modifier.padding(16.dp))
        }
    }
}
fun getContactList(): List<Contact> {
    val imageUrl = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=900&auto=format&fit=crop&q=60"
    val imageUrl2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwXRsEwpFFX0OKKI2dQwdnS3hsLq_2Bogf2g&s"
    val imageUrl3 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRY0lqLn3iPf6bLMX9XcEPuq0pfMmZ8ibmCSg&s"
    val imageUrl4 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOqjKmlrwryMl8m8eEDnDQdiP678Dxd6Ru1A&s"
    return arrayListOf(
        Contact(1, "Maria", "Gomez", "75678799",imageUrl ),
       Contact(2, "Juan", "Perez", "75678799",imageUrl2),
        Contact(3, "Pedro", "Gomez", "75678799",imageUrl3),
        Contact(4, "Maria", "Gomez", "75678799",imageUrl4),
        Contact(5, "Juan", "Perez", "75678799",imageUrl),
        Contact(6, "Pedro", "Gomez", "75678799",imageUrl2),
        Contact(7, "Maria", "Gomez", "75678799", imageUrl3),
        Contact(8, "Juan", "Perez", "75678799", imageUrl4),
        Contact(9, "Pedro", "Gomez", "75678799", imageUrl),
        Contact(10, "Maria", "Gomez", "75678799", imageUrl2),
        Contact(11, "Juan", "Perez", "75678799", imageUrl3),
        Contact(12, "Pedro", "Gomez", "75678799", imageUrl4),
        Contact(13, "Maria", "Gomez", "75678799", imageUrl),
        Contact(14, "Juan", "Perez", "75678799", imageUrl3),
        Contact(15, "Pedro", "Gomez", "75678799", imageUrl4),
        Contact(16, "Carla", "Amatista", "90988303", imageUrl2),
        Contact(17, "Maria", "Gomez", "75678799", imageUrl),
        Contact(18, "Juan", "Perez", "75678799", imageUrl2),
        Contact(19, "Pedro", "Gomez", "75678799", imageUrl3),
        Contact(20, "Maria", "Gomez", "75678799", imageUrl4),


    )
}


@Composable
fun MessageList( modifier: Modifier = Modifier) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp), modifier = Modifier.fillMaxWidth()) {
        items(100){
            Text(text = "Item #$it", modifier = Modifier.padding(16.dp))
        }
    }
}



@Preview(showBackground = true)
/*
@Composable
fun MessageListPreview() {
    PracticaListasTheme {
        MessageList()
    }
}*/

@Preview(showBackground = true)
@Composable
fun ContactItemPreview() {

    val imageUrl = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=900&auto=format&fit=crop&q=60"

    PracticaListasTheme {
        ContactItem(Contact(1, "Maria", "Gomez", "75678799",    imageUrl))
    }
}