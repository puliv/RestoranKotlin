package org.example.model

abstract class Producto {
    var tipo: String = "";
    var nombre: String = "";
    var precio: Int = 0;

    abstract fun mostrarInfo();
}