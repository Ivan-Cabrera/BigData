# Unidad 2

#### Machine Learning es una disciplina científica del ámbito de la Inteligencia Artificial que crea sistemas que aprenden automáticamente. Aprender en este contexto quiere decir identificar patrones complejos en millones de datos. La máquina que realmente aprende es un algoritmo que revisa los datos y es capaz de predecir comportamientos futuros. Automáticamente, también en este contexto, implica que estos sistemas se mejoran de forma autónoma con el tiempo, sin intervención humana. Veamos cómo funciona.

## Regresión logística

La regresión logística es un método popular para predecir una respuesta categórica. Es un caso especial de modelos lineales generalizados que predice la probabilidad de los resultados. En spark.ml la regresión logística se puede usar para predecir un resultado binario usando regresión logística binomial, o se puede usar para predecir un resultado multiclase usando regresión logística multinomial. Use el family parámetro para seleccionar entre estos dos algoritmos, o déjelo sin configurar y Spark inferirá la variante correcta.

### Regresión logística binomial

La regresión logística binaria se puede generalizar en regresión logística multinomial para entrenar y predecir problemas de clasificación multiclase.

### Regresión logística multinomial

La clasificación multiclase se admite mediante regresión logística multinomial (softmax). En la regresión logística multinomial, el algoritmo produce K conjuntos de coeficientes, o una matriz de dimensión K*J donde K es el número de clases de resultados y J es la cantidad de características.

## Clasificador de árbol de decisión

Los árboles de decisión y sus conjuntos son métodos populares para las tareas de clasificación y regresión del aprendizaje automático. Los árboles de decisión se usan ampliamente ya que son fáciles de interpretar, manejar características categóricas, extenderse a la configuración de clasificación multiclase, no requieren escala de características y son capaces de capturar no linealidades e interacciones de características. Los algoritmos de conjunto de árboles, como los bosques aleatorios y el refuerzo, se encuentran entre los de mejor desempeño para las tareas de clasificación y regresión.

## Clasificador aleatorio de bosque

Los bosques aleatorios son conjuntos de árboles de decisión . Los bosques aleatorios combinan muchos árboles de decisión para reducir el riesgo de sobreajuste. La implementación de spark.ml admite bosques aleatorios para clasificación binaria y multiclase y para regresión, utilizando características continuas y categóricas.

## Clasificador de árbol impulsado por gradiente

Los árboles impulsados por gradientes (GBT) son conjuntos de árboles de decisión . Los GBT capacitan iterativamente los árboles de decisión para minimizar una función de pérdida. La implementación de spark.ml admite GBT para la clasificación binaria y para la regresión, utilizando características continuas y categóricas.

## Clasificador perceptrón multicapa

El clasificador de perceptrón multicapa (MLPC) es un clasificador basado en la red neuronal artificial de alimentación directa. MLPC consta de múltiples capas de nodos. Cada capa está completamente conectada a la siguiente capa en la red. Los nodos en la capa de entrada representan los datos de entrada. Todos los demás nodos asignan entradas a salidas mediante una combinación lineal de las entradas con los pesos W y la polarización B del nodo y aplicando una función de activación.

## Máquina lineal de vectores de soporte

Una máquina de vectores de soporte construye un hiperplano o un conjunto de hiperplanos en un espacio de dimensión alta o infinita, que puede usarse para clasificación, regresión u otras tareas. Intuitivamente, se logra una buena separación mediante el hiperplano que tiene la mayor distancia a los puntos de datos de entrenamiento más cercanos de cualquier clase (denominado margen funcional), ya que en general cuanto mayor es el margen, menor es el error de generalización del clasificador. LinearSVC en Spark ML admite la clasificación binaria con SVM lineal. Internamente, optimiza la pérdida de la bisagra utilizando el optimizador OWLQN.

## Clasificador One-vs-Rest (también conocido como One-vs-All)

OneVsRest es un ejemplo de una reducción de aprendizaje automático para realizar una clasificación multiclase dado un clasificador base que puede realizar la clasificación binaria de manera eficiente. También se conoce como "Uno contra todos".

OneVsRest se implementa como un Estimator. Para el clasificador base, toma instancias de Classifier y crea un problema de clasificación binaria para cada una de las k clases. El clasificador para la clase i está entrenado para predecir si la etiqueta es i o no, distinguiendo la clase i de todas las demás clases.

Las predicciones se realizan evaluando cada clasificador binario y el índice del clasificador más seguro se genera como etiqueta.

## Naive Bayes

Los clasificadores Naive Bayes son una familia de clasificadores probabilísticos simples y multiclase basados ​​en la aplicación del teorema de Bayes con fuertes supuestos de independencia (ingenuos) entre cada par de características.

Naive Bayes puede ser entrenado de manera muy eficiente. Con un solo paso sobre los datos de entrenamiento, calcula la distribución de probabilidad condicional de cada característica dada cada etiqueta. Para la predicción, aplica el teorema de Bayes para calcular la distribución de probabilidad condicional de cada etiqueta dada una observación.
