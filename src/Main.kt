// Se utiliza la siguiente librería de Java para permitir la entrada de datos por consola
import java.util.Scanner

// Función principal para gestionar las cabinas telefónicas
fun main() {
    // Crea un objeto Scanner para leer entradas del usuario desde la consola
    val scanner = Scanner(System.`in`)

    /* Le solicita al usuario la cantidad de cabinas telefónicas, y crea un identificador único
       para cada cabina. Estas se crean por medio de un arreglo. */
    // println("Ingrese el número de cabinas telefónicas:")
    // val numCabinas = scanner.nextInt()
    var numCabinas = 1
    println("-------------------------------------------------------------")
    println("El número de cabinas disponibles es la siguiente: $numCabinas")
    println("-------------------------------------------------------------")
    var cabinas = Array(numCabinas) { CabinaTelefonica(it + 1) }

    /* Se crea una variable llamada continuar la cual, con el while, generará un bucle que permitirá al usuario
       seleccionar diferentes opciones hasta que solicite salir. */
    var continuar = true
    while (continuar) {
        // Muestra las opciones disponibles al usuario
        println("\nOpciones:")
        println("1. Registrar una llamada")
        println("2. Mostrar información de una cabina")
        println("3. Mostrar consolidado total")
        println("4. Reiniciar una cabina")
        println("5. Agregar más cabinas") // Nueva opción para poder agregar más cabinas si es necesario
        println("6. Salir")
        print("Seleccione una opción: ")
        val opcion = scanner.nextInt()

        // Maneja la opción seleccionada por el usuario
        when (opcion) {
            /* Opción para registrar una llamada, el cual con ayuda de un if tomara en cuenta el número de cabinas entre
               1 hasta el número de cabinas que digite el usuario.
            */
            1 -> {
                print("Ingrese el número de cabina: ")
                val cabinaId = scanner.nextInt()
                if (cabinaId in 1..numCabinas) {
                    print("Ingrese el tipo de llamada (local, larga_distancia, celular): ")
                    val tipoLlamada = scanner.next()
                    print("Ingrese la duración de la llamada en minutos: ")
                    val duracionLlamada = scanner.nextInt()

                    // Llama a la función para registrar la llamada en la cabina especificada
                    registrarLlamada(cabinas[cabinaId - 1], tipoLlamada, duracionLlamada)
                } else {
                    println("Cabina no válida.")
                }
            }
            // Opción para mostrar la información detallada de una cabina
            2 -> {
                print("Ingrese el número de cabina: ")
                val cabinaId = scanner.nextInt()
                if (cabinaId in 1..numCabinas) {
                    // Llama a la función para mostrar la información de la cabina especificada
                    mostrarInformacion(cabinas[cabinaId - 1])
                } else {
                    println("Cabina no válida.")
                }
            }
            // Opción para mostrar el consolidado total de todas las cabinas
            3 -> {
                var totalLlamadas = 0
                var totalDuracion = 0
                var totalCosto = 0

                // Calcula los totales acumulando los datos de cada cabina
                for (cabina in cabinas) {
                    totalLlamadas += cabina.numLlamadas
                    totalDuracion += cabina.duracionTotal
                    totalCosto += cabina.costoTotal
                }

                // Calcula el costo promedio por minuto si hay duración total; de lo contrario, establece en 0
                val costoPromedioPorMinuto = if (totalDuracion != 0) totalCosto / totalDuracion else 0

                // Muestra el consolidado total de todas las cabinas
                println("------------------------------")
                println("Consolidado total:")
                println("Número total de llamadas realizadas: $totalLlamadas")
                println("Duración total de llamadas: $totalDuracion minutos")
                println("Costo total de llamadas: $totalCosto pesos")
                println("Costo promedio por minuto: $costoPromedioPorMinuto pesos/minuto")
                println("------------------------------")
            }
            // Opción para reiniciar los datos de una cabina
            4 -> {
                print("Ingrese el número de cabina a reiniciar: ")
                val cabinaId = scanner.nextInt()
                if (cabinaId in 1..numCabinas) {
                    // Llama a la función para reiniciar la cabina especificada
                    reiniciarCabina(cabinas[cabinaId - 1])
                } else {
                    println("Cabina no válida.")
                }
            }
            // Nueva opción para agregar más cabinas
            5 -> {
                print("Ingrese la cantidad de cabinas adicionales: ")
                val cabinasAdicionales = scanner.nextInt()
                if (cabinasAdicionales > 0) {
                    // Crea un nuevo arreglo con el tamaño incrementado
                    val nuevasCabinas = Array(numCabinas + cabinasAdicionales) { index ->
                        if (index < numCabinas) cabinas[index] else CabinaTelefonica(index + 1)
                    }
                    cabinas = nuevasCabinas
                    numCabinas += cabinasAdicionales
                    println("Ahora hay un total de $numCabinas cabinas.")
                } else {
                    println("Cantidad de cabinas adicionales no válida.")
                }
            }
            // Opción para salir del sistema
            6 -> {
                continuar = false
                println("Saliendo del sistema.")
            }
            // Maneja opciones no válidas ingresadas por el usuario
            else -> println("Opción no válida.")
        }
    }

    // Cierra el objeto Scanner al finalizar el programa para liberar los recursos
    scanner.close()
}
