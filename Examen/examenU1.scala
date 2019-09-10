// 15510506
// Cabrera Reyes Ivan
// Datos Masivos
// Examen Unidad 1

// Definscicion de funcion breakingRecords
// Parametros: Score, lista de puntuaciones de los partidos de una temporada

val score1 = List(10,5,20,20,4,5,2,25,1)      // Lista de puntajes correspondientes a la primer temporada
val score2 = List(3,4,21,36,10,28,35,5,24,42) // Lista de puntajes correspondientes a la segunda temporada


def breakingRecords(Score:List[Int]): Unit =
{    
    var min = Score(0)      // La variable min almacena el valor de la posicion 0 de la lista de puntajes
    var max = Score(0)      // La variable max almacena el valor de la posicion 0 de la lista de puntajes

    var cmin = 0            // La variable cmin almacena las veces que se rompe el record de los puntajes minimos
    var cmax = 0            // La variable cmax almacena las veces que se rompe el record de los puntajes maximos

    var sl = 0              // La variable sirve con contador para verificar el elemento actual de la lista

    while(sl < Score.size)  // Recorre la lista hasta el final
    {
        if(min > Score(sl))
        {
            cmin = cmin + 1 // Si el valor de la posicion actual de la lista es menor al minimo se incrementa el contador
            min = Score(sl) // Si el valor fue menor, el minimo toma el valor de la posicion actual de la lista
        }

        if(max < Score(sl)) 
        {
            cmax = cmax + 1 // Si el valor de la posicion actual de la lista es mayor al maximo se incrementa el contador
            max = Score(sl) // Si el valor fue mayor, el maximo toma el valor de la posicion actual de la lista
        }

        sl = sl + 1         // Se incrementa el valor del contador sl, el cual indica el valor de la posicion actual de la lista
    }

    println("Resultados de la temporada:")
    println("Maximo: " + cmax)
    println("Minimo: " + cmin)
}