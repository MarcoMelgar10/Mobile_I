package com.example.practicalistacompleta

import java.io.Serializable

class Persona(
    var id: String,
    var nombre: String,
    var telefono: String,
    var direccion: String,
): Serializable {
}