package org.example
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.example.model.Bebida
import org.example.model.Comida
import org.example.model.Producto
import org.example.util.EstadoPedido

fun main(): Unit = runBlocking {
    val listaProductos = mutableListOf<Producto>();
    cargarProductos(listaProductos);

    println("============");
    println("NUESTRO MENU");
    println("============");
    var contador: Int = 1;
    listaProductos.forEach { p ->
        print("$contador.- ")
        p.mostrarInfo();
        contador++;
    }

    println();
    print("INGRESE SU PEDIDO: ");
    val respuesta = readln();
    val listaRespuesta = respuesta.split(",");

    val estadoFinal = crearPedido(listaProductos, listaRespuesta) // las suspend fun deben ser invocadas dentro de una corutina

    when (estadoFinal) {
        is EstadoPedido.Exito -> println(estadoFinal.mensaje)
        is EstadoPedido.Error -> println(estadoFinal.mensaje)
    }
}

suspend fun crearPedido(listaProductos: MutableList<Producto>, listaRespuesta: List<String>): EstadoPedido {
    try {
        println("Cargando...")
        delay(3000) //simulando una demora

        var total: Int = 0;
        listaRespuesta.forEach { t ->
            listaProductos[t.toInt() - 1].mostrarInfo();
            total = total + listaProductos[t.toInt() - 1].precio;
        }
        println("TOTAL DE SU COMPRA: $total");

        return EstadoPedido.Exito("Pedido creado con exito")
    } catch (e: Exception) {

        return EstadoPedido.Error("Error con el pedido")

    }
}

fun cargarProductos(listaProductos: MutableList<Producto>) {
    val c1 = Comida();
    c1.nombre = "Completito";
    c1.premium = false;
    c1.precio = 2200;

    val c2 = Comida();
    c2.nombre = "Salmón con Puré";
    c2.premium = true;
    c2.precio = 20000;

    val b1 = Bebida();
    b1.nombre = "Redbull";
    b1.precio = 1990;
    b1.tamanio = "Pequeña";

    val b2 = Bebida();
    b2.nombre = "Coca Cola";
    b2.precio = 2000;
    b2.tamanio = "Mediana";

    listaProductos.add(c1);
    listaProductos.add(c2);
    listaProductos.add(b1);
    listaProductos.add(b2);
}