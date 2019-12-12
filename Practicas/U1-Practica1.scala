

//1. Desarrollar un algoritmo en scala que calcule el radio de un círculo
var perimetro = 20
var radio = perimetro /(2* 3.1416)
println(s"El radio del círculo es : $radio")

//2. Desarrollar un algoritmo en scala que me diga si un número es primo
var numero = 2
if(numero !=2)
{
	if(numero%2 == 0)
     {
		println(s”$numero no es primo")
     }
  	else
     {
		println(s"$numero es primo")
     }
}
else
{
	println(s"$numero es primo")
}



//3. Dada la variable bird = "tweet", utiliza interpolación de string para imprimir "Estoy escribiendo un tweet"
val bird = "tweet"
val message = s"Estoy escribiendo un $bird"
println(message)

//4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la secuencia "Luke"
val mensaje = "Hola Luke, yo soy tu padre!"
val substr = mensaje slice(5,9)
println(substr)

//5. Cual es la diferencia en value y una variable en scala?
println("El tipo val es una variable que no puede cambiar su valor, en otros lenguajes su equivalente es una constante, por otro lado var si permite modificar su valor en posteriores ocasiones")

//6. Dada la tupla ((2,4,5),(1,2,3),(3.1416,23))) regresa el número 3.1416
val tup = ((2,4,5), (1,2,3),(3.1416,23))
tup._3._1
