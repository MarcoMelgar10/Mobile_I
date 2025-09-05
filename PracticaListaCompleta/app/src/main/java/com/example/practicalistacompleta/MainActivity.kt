package com.example.practicalistacompleta

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalistacompleta.ui.DetailPersonActivity
import com.example.practicalistacompleta.ui.theme.PracticaListaCompletaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PracticaListaCompletaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Lista(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Lista( modifier: Modifier = Modifier) {
    val person = generarListaPersonas()
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp), modifier = Modifier.fillMaxWidth())
    {
        items(person) {it ->
            PersonaItem(it)
            HorizontalDivider(thickness = 1.dp)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ListaPreview() {
    PracticaListaCompletaTheme {
        Lista()
    }
}

@Composable
fun generarListaPersonas(): List<Persona> {
    val nombres = listOf("Jorge", "Pedro", "Martin", "Carlos", "Andres", "Felipe", "Oscar")
    val numberOfPeopleToCreate = minOf(5, nombres.size)

    val personas = mutableListOf<Persona>()
    for (i in 0 until numberOfPeopleToCreate) {
        val persona = Persona(
            (i + 1).toString(),
            nombres[i],
            "756${i + 1}61",
            "Radial ${i + 1}"
        )
        personas.add(persona)
    }
    return personas
}

@Composable
fun PersonaItem(persona: Persona) {
    val context = LocalContext.current
    Spacer(modifier = Modifier.size(8.dp))
    Column(
        modifier = Modifier.clickable {
            val intent = Intent(context, DetailPersonActivity::class.java).apply {
                putExtra("persona", persona)
            }
            context.startActivity(intent)
        }
            .fillMaxWidth()
    ) {
        Text(persona.nombre, modifier = Modifier.padding(16.dp))
        Text(text = persona.telefono, modifier = Modifier.padding(16.dp))
    }
}