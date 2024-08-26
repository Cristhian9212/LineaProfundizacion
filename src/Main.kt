import java.util.Scanner

// Función principal para gestionar las cabinas telefónicas
fun main() {
    val scanner = Scanner(System.`in`)
    println("Ingrese el número de cabinas telefónicas:")
    val numCabinas = scanner.nextInt()

    // Crear un array de cabinas
    val cabinas = Array(numCabinas) { CabinaTelefonica(it + 1) }

    var continuar = true
    while (continuar) {
        println("\nOpciones:")
        println("1. Registrar una llamada")
        println("2. Mostrar información de una cabina")
        println("3. Mostrar consolidado total")
        println("4. Reiniciar una cabina")
        println("5. Salir")
        print("Seleccione una opción: ")
        val opcion = scanner.nextInt()

        when (opcion) {
            1 -> {
                print("Ingrese el número de cabina: ")
                val cabinaId = scanner.nextInt()
                if (cabinaId in 1..numCabinas) {
                    print("Ingrese el tipo de llamada (local, larga distancia, celular): ")
                    val tipoLlamada = scanner.next()
                    print("Ingrese la duración de la llamada en minutos: ")
                    val duracionLlamada = scanner.nextInt()

                    registrarLlamada(cabinas[cabinaId - 1], tipoLlamada, duracionLlamada)
                } else {
                    println("Cabina no válida.")
                }
            }
            2 -> {
                print("Ingrese el número de cabina: ")
                val cabinaId = scanner.nextInt()
                if (cabinaId in 1..numCabinas) {
                    mostrarInformacion(cabinas[cabinaId - 1])
                } else {
                    println("Cabina no válida.")
                }
            }
            3 -> {
                var totalLlamadas = 0
                var totalDuracion = 0
                var totalCosto = 0

                for (cabina in cabinas) {
                    totalLlamadas += cabina.numLlamadas
                    totalDuracion += cabina.duracionTotal
                    totalCosto += cabina.costoTotal
                }

                val costoPromedioPorMinuto = if (totalDuracion != 0) totalCosto / totalDuracion else 0

                println("Consolidado total:")
                println("Número total de llamadas realizadas: $totalLlamadas")
                println("Duración total de llamadas: $totalDuracion minutos")
                println("Costo total de llamadas: $totalCosto pesos")
                println("Costo promedio por minuto: $costoPromedioPorMinuto pesos/minuto")
                println("------------------------------")
            }
            4 -> {
                print("Ingrese el número de cabina a reiniciar: ")
                val cabinaId = scanner.nextInt()
                if (cabinaId in 1..numCabinas) {
                    reiniciarCabina(cabinas[cabinaId - 1])
                } else {
                    println("Cabina no válida.")
                }
            }
            5 -> {
                continuar = false
                println("Saliendo del sistema.")
            }
            else -> println("Opción no válida.")
        }
    }

    scanner.close()
}