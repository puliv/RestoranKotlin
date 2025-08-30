package org.example.model

class Bebida: Producto() {
    init {
        tipo = "Bebida";
    }
    var tamanio: String = "";

    override fun mostrarInfo() {
        println("TIPO: $tipo, NOMBRE: $nombre, " +
                "PRECIO: $precio, TAMAÑO: $tamanio");
    }
}