# LineaProfundización

# Sistema de Gestión de Cabinas Telefónicas

Este proyecto implementa un sistema básico de gestión para cabinas telefónicas utilizando Kotlin. El sistema permite a los usuarios registrar llamadas, mostrar información detallada de cada cabina, ver un consolidado de todas las cabinas y reiniciar los datos de una cabina específica.

## Funcionalidades

El sistema ofrece las siguientes funcionalidades:

1. **Registrar una llamada**: Permite al usuario registrar una llamada en una cabina telefónica especificando el tipo de llamada (local, larga distancia, celular) y la duración de la llamada en minutos. El sistema calcula el costo de la llamada según el tipo de llamada.

2. **Mostrar información de una cabina**: Muestra los detalles de una cabina específica, incluyendo el número de llamadas realizadas, la duración total de las llamadas y el costo total.

3. **Mostrar consolidado total**: Muestra un resumen de todas las cabinas, incluyendo el número total de llamadas, la duración total de todas las llamadas, el costo total y el costo promedio por minuto.

4. **Reiniciar una cabina**: Reinicia los datos de una cabina específica, poniendo a cero el número de llamadas, la duración total y el costo total.

5. **Salir**: Permite al usuario salir del sistema.

## Estructura del Código

### Clases y Funciones

- **Clase `CabinaTelefonica`**: Representa una cabina telefónica con un identificador único, número de llamadas realizadas, duración total de las llamadas y costo total de las llamadas.

- **Función `main`**: Función principal que gestiona la interacción del usuario con el sistema. Solicita el número de cabinas y ofrece un menú de opciones para el usuario.

- **Función `registrarLlamada(cabina, tipo, duracion)`**: Registra una llamada en la cabina especificada y actualiza el número de llamadas, la duración total y el costo total.

- **Función `mostrarInformacion(cabina)`**: Muestra la información detallada de una cabina específica.

- **Función `reiniciarCabina(cabina)`**: Reinicia los datos de la cabina a cero.

## Uso

1. Al iniciar el programa, se solicita al usuario que ingrese el número de cabinas telefónicas.
2. El usuario puede seleccionar diferentes opciones desde un menú para registrar llamadas, mostrar información, ver un consolidado total, reiniciar cabinas o salir del sistema.
3. Las opciones se manejan mediante una estructura de control `when` para ejecutar la acción correspondiente.

## Ejecución del Programa

1. Compila y ejecuta el archivo Kotlin usando un IDE compatible con Kotlin o desde la línea de comandos.
2. Sigue las instrucciones en consola para interactuar con el sistema de gestión de cabinas telefónicas.

## Notas

- El sistema utiliza la clase `Scanner` de Java para la entrada de datos por consola.
- Es importante cerrar el objeto `Scanner` al finalizar el uso para liberar recursos.
