package com.example.practicalistacompleta.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Size
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalistacompleta.Persona
import com.example.practicalistacompleta.ui.ui.theme.PracticaListaCompletaTheme

class DetailPersonActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val persona = intent.getSerializableExtra("persona") as Persona

        setContent {
            PracticaListaCompletaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PersonDetail(
                        person = persona,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("ContextCastToActivity")
@Composable
fun PersonDetail(person: Persona,   modifier: Modifier = Modifier) {
    val activity = (LocalContext.current as? Activity)
    Column(modifier = modifier.padding(16.dp)) {
        OutlinedTextField(
            person.nombre,
            onValueChange = {  },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            person.telefono,
            onValueChange = {  },
            label = { Text("Telefono") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            person.direccion,
            onValueChange = {  },
            label = { Text("Direccion") },
            modifier = Modifier.fillMaxWidth()
        )
        Button({

        }, Modifier.fillMaxWidth()) { Text("Guardar") }

        Button({
            activity?.finish()
        }, Modifier.fillMaxWidth()) { Text("Salir") }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonDetailPreview() {
    PracticaListaCompletaTheme {
        PersonDetail(Persona("1", "Jorge", "7566161", "Radial"))
    }
}