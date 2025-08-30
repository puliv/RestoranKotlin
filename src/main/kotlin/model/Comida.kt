package org.example.model

class Comida: Producto() {
    init {
        tipo = "Comida";
    }
    var premium: Boolean = false;

    override fun mostrarInfo() {
        println("TIPO: $tipo, NOMBRE: $nombre, " +
                "PRECIO: $precio")
    }
}