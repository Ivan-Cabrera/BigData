# Unidad 4 - Proyecto Integrador

## Tabla de Contenidos
<details>
<summary>"Ver más"</summary>
 
- [Introducción](#Introducción)
- [Capítulo I: Algoritmos de Machine Learning](#Capítulo I: Algoritmos de Machine Learning)
  * [1.1 SVM (Support Vector Machine)](#1.1 SVM (Support Vector Machine))
    * [1.1.1 Hiperplanos y vectores de soporte](#1.1.1 Hiperplanos y vectores de soporte)
    * [1.1.2 Intuición de gran margen](#1.1.2 Intuición de gran margen)
    * [1.1.3 Función de costo y actualizaciones de gradiente](#1.1.3 Función de costo y actualizaciones de gradiente)
  * [1.2 Logistic Regression (regresión logística)](#1.2 Logistic Regression (regresión logística))
    * [1.2.1 Función Logit](#1.2.1 Función Logit)
    * [1.2.2 Estimación de coeficientes de regresión](#1.2.2 Estimación de coeficientes de regresión)
    * [1.2.3 Rendimiento del modelo de regresión logística](#1.2.3 Rendimiento del modelo de regresión logística)
  * [1.3 Multilayer perceptron (perceptrón multicapa)](#1.3 Multilayer perceptron (perceptrón multicapa))
    * [1.3.1 Función de activación](#1.3.1 Función de activación)
    * [1.3.2 Entrenando al modelo](#1.3.2 Entrenando al modelo)
      * [1.3.2.1 Pase hacia adelante](#1.3.2.1 Pase hacia adelante)
      * [1.3.2.2 Calcular la pérdida](#1.3.2.2 Calcular la pérdida)
      * [1.3.2.3 Pase hacia atrás](#1.3.2.3 Pase hacia atrás)
- [Capítulo II: Implementación](#Capítulo II: Implementación)
- [Capítulo III: Resultados](#Capítulo III: Resultados)
  * [3.1 Algoritmos](#3.1 Algoritmos)
    * [3.1.1 SVM (Support Vector Machine)](#3.1.1 SVM (Support Vector Machine))
    * [3.1.2 Logistic Regression (regresión logística)](#3.1.2 Logistic Regression (regresión logística))
    * [3.1.3 Multilayer perceptron (perceptrón multicapa))](#3.1.3 Multilayer perceptron (perceptrón multicapa))
  * [3.2 Tabla de resultados](#3.2 Tabla de resultados)
- [Conclusiones](#Conclusiones)
- [Referencias](#Referencias)
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


















