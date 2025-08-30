package org.example.util

sealed class EstadoPedido {
    //las clases selladas son clases utiles para manejar estados
    //Sabemos que la data class hereda de estadoPedido por los dos puntos ':' que equivalen al extends de java
    data class Exito(val mensaje: String) : EstadoPedido()
    //data class: son clases destinadas solo a recibir valores, no tienen funcionalidad
    data class  Error(val mensaje: String) : EstadoPedido()
}