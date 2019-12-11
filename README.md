# Unidad 4

## Proyecto Integrador

### El principal proposito del proyecto es presentar una comparación del rendimiento de diferentes algoritmos de Machine Learning, los algoritmos a tratar son Logistic Regression, Support Vector Machine y Multilayer Perceptron


### Regresión logística
La regresión logística es un método popular para predecir una respuesta categórica. Es un caso especial de modelos lineales generalizados que predice la probabilidad de los resultados. En spark.ml la regresión logística se puede usar para predecir un resultado binario usando regresión logística binomial, o se puede usar para predecir un resultado multiclase usando regresión logística multinomial. Use el family parámetro para seleccionar entre estos dos algoritmos, o déjelo sin configurar y Spark inferirá la variante correcta.

#### Regresión logística binomial
La regresión logística binaria se puede generalizar en regresión logística multinomial para entrenar y predecir problemas de clasificación multiclase.

#### Regresión logística multinomial
La clasificación multiclase se admite mediante regresión logística multinomial (softmax). En la regresión logística multinomial, el algoritmo produce K conjuntos de coeficientes, o una matriz de dimensión K*J donde K es el número de clases de resultados y J es la cantidad de características.


### Máquina lineal de vectores de soporte
Una máquina de vectores de soporte construye un hiperplano o un conjunto de hiperplanos en un espacio de dimensión alta o infinita, que puede usarse para clasificación, regresión u otras tareas. Intuitivamente, se logra una buena separación mediante el hiperplano que tiene la mayor distancia a los puntos de datos de entrenamiento más cercanos de cualquier clase (denominado margen funcional), ya que en general cuanto mayor es el margen, menor es el error de generalización del clasificador. LinearSVC en Spark ML admite la clasificación binaria con SVM lineal. Internamente, optimiza la pérdida de la bisagra utilizando el optimizador OWLQN.

### Clasificador perceptrón multicapa
El clasificador de perceptrón multicapa (MLPC) es un clasificador basado en la red neuronal artificial de alimentación directa. MLPC consta de múltiples capas de nodos. Cada capa está completamente conectada a la siguiente capa en la red. Los nodos en la capa de entrada representan los datos de entrada. Todos los demás nodos asignan entradas a salidas mediante una combinación lineal de las entradas con los pesos W y la polarización B del nodo y aplicando una función de activación.