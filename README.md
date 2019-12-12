# Unidad 4 - Proyecto Integrador

## Tabla de Contenidos
<details>
<summary>"Ver más"</summary>
 
- Introducción
- Capítulo I: Algoritmos de Machine Learning
  * 1.1 SVM (Support Vector Machine)
    - 1.1.1 Hiperplanos y vectores de soporte
    - 1.1.2 Intuición de gran margen
    - 1.1.3 Función de costo y actualizaciones de gradiente
  * 1.2 Logistic Regression (regresión logística)
    - 1.2.1 Función Logit
    - 1.2.2 Estimación de coeficientes de regresión
    - 1.2.3 Rendimiento del modelo de regresión logística
  * 1.3 Multilayer perceptron (perceptrón multicapa)
    * 1.3.1 Función de activación
    * 1.3.2 Entrenando al modelo
      * 1.3.2.1 Pase hacia adelante
      * 1.3.2.2 Calcular la pérdida
      * 1.3.2.3 Pase hacia atrás
- Capítulo II: Implementación
- Capítulo III: Resultado
  * 3.1 Algoritmos
    * 3.1.1 SVM (Support Vector Machine)
    * 3.1.2 Logistic Regression (regresión logística)
    * 3.1.3 Multilayer perceptron (perceptrón multicapa)
  * 3.2 Tabla de resultados
- Conclusiones
- Referencias
</details>

# Introducción
Machine Learning es un campo de la computación que poco a poco ha ido tomando fuerza, permitiendo que cada vez más programadores y científicos de datos incursionen en el mar de la información.

Para poder aprovechar la capacidad de éstas técnicas se han desarrollado herramientas las cuales permiten elaborar algoritmos que optimizan procesos tardados de cálculos que generan una enorme cantidad de datos.

A lo largo de la historia se han ido generando millones y millones de datos, los cuales pueden ser analizados o “minados” a través de múltiples métodos.

Tomando como base lo anterior es posible mencionar que uno de los avances más importantes de la actualidad ha sido la capacidad de crear algoritmos que mediante el aprendizaje supervisado obtengan datos de una manera tan eficiente que hasta ha sido posible disminuir en gran manera horas o incluso días de trabajo

# Capítulo I: Algoritmos de Machine Learning

## 1.1 SVM (Support Vector Machine)

Una máquina de vectores de soporte (SVM) es un clasificador discriminativo definido formalmente por un hiperplano de separación. En otras palabras, dados los datos de entrenamiento etiquetados ( aprendizaje supervisado ), el algoritmo genera un hiperplano óptimo que categoriza nuevos ejemplos.

En dos espacios dimensionales, este hiperplano es una línea que divide un plano en dos partes donde en cada clase se encuentra a cada lado.

El objetivo del algoritmo de máquina de vectores de soporte es encontrar un hiperplano en un espacio N-dimensional (N - el número de características) que clasifica claramente los puntos de datos.

Para separar las dos clases de puntos de datos, hay muchos hiperplanos posibles que podrían elegirse. El objetivo es encontrar un plano que tenga el margen máximo, es decir, la distancia máxima entre los puntos de datos de ambas clases. Maximizar la distancia de margen proporciona cierto refuerzo para que los puntos de datos futuros se puedan clasificar con más confianza.

### 1.1.1 Hiperplanos y vectores de soporte

Los hiperplanos son límites de decisión que ayudan a clasificar los puntos de datos. Los puntos de datos que caen a ambos lados del hiperplano se pueden atribuir a diferentes clases. Además, la dimensión del hiperplano depende del número de características. Si el número de características de entrada es 2, entonces el hiperplano es solo una línea. Si el número de características de entrada es 3, entonces el hiperplano se convierte en un plano bidimensional. Se hace difícil imaginar cuando la cantidad de características excede 3.

Los vectores de soporte son puntos de datos que están más cerca del hiperplano e influyen en la posición y orientación del hiperplano. Usando estos vectores de soporte, maximizamos el margen del clasificador. Eliminar los vectores de soporte cambiará la posición del hiperplano. Estos son los puntos que nos ayudan a construir nuestro SVM.

### 1.1.2 Intuición de gran margen

En la regresión logística, tomamos la salida de la función lineal y aplastamos el valor dentro del rango de [0,1] usando la función sigmoide. Si el valor aplastado es mayor que un valor umbral (0.5), le asignamos una etiqueta 1, de lo contrario, le asignamos una etiqueta 0. En SVM, tomamos la salida de la función lineal y si esa salida es mayor que 1, identificamos con una clase y si la salida es -1, la identificamos con otra clase. Dado que los valores de umbral se cambian a 1 y -1 en SVM, obtenemos este rango de valores de refuerzo ([- 1,1]) que actúa como margen.

### 1.1.3 Función de costo y actualizaciones de gradiente

En el algoritmo SVM, buscamos maximizar el margen entre los puntos de datos y el hiperplano. La función de pérdida que ayuda a maximizar el margen es la pérdida de bisagra.












