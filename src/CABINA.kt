/* Data class para representar una cabina telefónica: Se crea una clase llamada cabina telefonica la cual
define una series de variables que inicialmente iniciaran en cero que servirán como contadores y que seran
un tipo de dato entero.
*/
data class CabinaTelefonica(
    val id: Int,
    var numLlamadas: Int = 0,
    var duracionTotal: Int = 0, // en minutos
    var costoTotal: Int = 0     // en pesos
)
/*En la clase CABINA se van a contar con tres funciones:

Función para registrar una llamada, en esta se van a calcular el tipo de llamada que se piense realizar
y el costo según la opción que se tome, este se apoya de la función when el cual evaluara el tipo de llamada
y le asignara un costo a esta, en caso de que no se seleccione una opción válida saldrá el mensaje de advertencia
puesto en el print.

*/
fun registrarLlamada(cabina: CabinaTelefonica, tipo: String, duracion: Int) {
    val costoPorMinuto = when (tipo.lowercase()) {
        "local" -> 50
        "larga_distancia" -> 350
        "celular" -> 150
        else -> {
            println("Tipo de llamada no válido.")
            return
        }
    }
/* En las líneas 32 a 34 se tendran las variables las cuales almacenaran los registros de la cabina
 */
    cabina.numLlamadas++
    cabina.duracionTotal += duracion
    cabina.costoTotal += costoPorMinuto * duracion
    println("Llamada registrada exitosamente en la cabina ${cabina.id}.")
}

/* Función para mostrar información detallada de una cabina, esta función nos ayuda a mostrar la información
detallada sobre la cabina telefonica específica, y nos va a imprimir en la consola el identificador de la cabina,
número de llamadas realizadas, duracion y costo de las llamadas.
 */
fun mostrarInformacion(cabina: CabinaTelefonica) {
    println("Cabina ${cabina.id}:")
    println("Número de llamadas realizadas: ${cabina.numLlamadas}")
    println("Duración total de llamadas: ${cabina.duracionTotal} minutos")
    println("Costo total de llamadas: ${cabina.costoTotal} pesos")
    println("------------------------------")
}

/* Función para reiniciar la cabina, es la última función dentro de la clase la cual tendra como objetivo de
reiniciar los valores a cero, ya que tiene la variable cabina que llama a la clase CabinaTelefonica esto reiniciara
los valores de la cabina a cero, e imprimirá el reinicio de la cabina seleccionada.

 */
fun reiniciarCabina(cabina: CabinaTelefonica) {
    cabina.numLlamadas = 0
    cabina.duracionTotal = 0
    cabina.costoTotal = 0
    println("Cabina ${cabina.id} reiniciada.")
}