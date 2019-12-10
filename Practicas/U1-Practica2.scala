

// 1. Crea una lista llamad "lista" con los elementos "rojo", "blanco", "negro"
var lista = collection.mutable.Set("rojo","blanco","negro")

// 2. Añadir 5 elementos más a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
lista+=("verde","amarillo","azul","naranja","perla")

// 3. Traer los elementos de "lista" "verde", "amarillo", "azul"
for(i<- lista)
{
     if(i=="rojo" || i=="verde" || i=="amarillo" || i== "azul")
     {
         println(i)
     }
}

// 4. Crea un arreglo de número en rango del 1-1000 en pasos de 5 en 5
var array_number = Array(1,1000,5)

// 5. Cuales son los elementos únicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversión a conjuntos
var lista = List(1,3,3,4,6,7,3,7)
var unicos = lista.toSet
println(unicos)

// 6. Crea una mapa mutable llamado nombres que contenga los siguiente  "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
var nombres = collection.mutable.Map(("Jose",2),("Luis",24),("Ana",23),("Susana",27))
// 6 a . Imprime todas la llaves del mapa
nombres.keys
// 6 b . Agrega el siguiente valor al mapa("Miguel", 23)
nombres+= ("Miguel"->23)

