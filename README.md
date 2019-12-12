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

El costo es 0 si el valor predicho y el valor real son del mismo signo. Si no lo son, calculamos el valor de la pérdida. También agregamos un parámetro de regularización a la función de costo. El objetivo del parámetro de regularización es equilibrar la maximización del margen y la pérdida. Después de agregar el parámetro de regularización, las funciones de costo se ven a continuación.

Ahora que tenemos la función de pérdida, tomamos derivadas parciales con respecto a los pesos para encontrar los gradientes. Usando los gradientes, podemos actualizar nuestros pesos.

Cuando no hay una clasificación errónea, es decir, nuestro modelo predice correctamente la clase de nuestro punto de datos, solo tenemos que actualizar el gradiente desde el parámetro de regularización.

Cuando hay una clasificación errónea, es decir, nuestro modelo comete un error en la predicción de la clase de nuestro punto de datos, incluimos la pérdida junto con el parámetro de regularización para realizar la actualización del gradiente.

## 1.2 Logistic Regression (regresión logística)

Es un algoritmo de clasificación, que se usa donde la variable de respuesta es categórico. La idea de la regresión logística es encontrar una relación entre características y probabilidad de resultado particular.

Por ejemplo, cuando tenemos que predecir si un alumno aprueba o no en un exámen cuando el número de horas dedicadas a estudiar se da como una característica, la variable de respuesta tiene dos valores, aprobar y reprobar.

Este tipo de problema se denomina Regresión logística binomial , donde la variable de respuesta tiene dos valores 0 y 1 o pasar y fallar o verdadero y falso. La regresión logística multinomial trata situaciones en las que la variable de respuesta puede tener tres o más valores posibles.

Con la clasificación binaria, deje que 'x' sea alguna característica e 'y' sea la salida que puede ser 0 o 1.

El modelo de regresión lineal puede generar la probabilidad pronosticada como cualquier número que va del infinito negativo al positivo, mientras que la probabilidad de un resultado solo puede estar entre 0 <P (x) <1.

### 1.2.1 Función Logit

Las probabilidades significan la relación de probabilidad de éxito a probabilidad de fracaso. Por lo tanto, en Regresión logística, la combinación lineal de entradas se asigna al registro (probabilidades), siendo la salida igual a 1. Si tomamos un inverso de la función anterior , obtenemos:

Esto se conoce como la función Sigmoide y da una curva en forma de S. Siempre da un valor de probabilidad que oscila entre 0 <p <1.

### 1.2.2 Estimación de coeficientes de regresión

A diferencia del modelo de regresión lineal, que usa el mínimo cuadrado ordinario para la estimación de parámetros, nosotros usamos la estimación de máxima verosimilitud .

Puede haber infinitos conjuntos de coeficientes de regresión. La estimación de máxima verosimilitud es el conjunto de coeficientes de regresión para los cuales la probabilidad de obtener los datos que hemos observado es máxima.

Si tenemos datos binarios, la probabilidad de cada resultado es simplemente π si fue un éxito, y 1 − π en caso contrario. Por lo tanto tenemos la función de probabilidad:

Para determinar el valor de los parámetros, se toma el registro de la función de probabilidad, ya que no cambia las propiedades de la función.

La probabilidad logarítmica se diferencia y, utilizando técnicas iterativas como el método de Newton, se determinan los valores de los parámetros que maximizan la probabilidad logarítmica.

### 1.2.3 Rendimiento del modelo de regresión logística

Para evaluar el rendimiento de un modelo de regresión logística, la desviación se usa en lugar de los cálculos de suma de cuadrados.

  - La desviación nula indica la respuesta predicha por un modelo con nada más que una intercepción.
  - La desviación del modelo indica la respuesta predicha por un modelo al agregar variables independientes. Si la desviación del modelo es significativamente menor que la desviación nula, se puede concluir que el parámetro o conjunto de parámetros mejoró significativamente el ajuste del modelo.
  - Otra forma de encontrar la precisión del modelo es utilizando la matriz de confusión.

## 1.3 Multilayer perceptron (perceptrón multicapa)

En el perceptrón multicapa, puede haber más de una capa lineal (combinaciones de neuronas ). Si tomamos el ejemplo simple de la red de tres capas, la primera capa será la capa de entrada y la última será la capa de salida y la capa intermedia se llamará capa oculta. Alimentamos nuestros datos de entrada en la capa de entrada y tomamos la salida de la capa de salida. Podemos aumentar el número de la capa oculta tanto como queramos, para hacer que el modelo sea más complejo de acuerdo con nuestra tarea.

Feed Forward Network, es el modelo de red neuronal más típico. Su objetivo es aproximar alguna función f (). Dado, por ejemplo, un clasificador y = f ∗ (x)que asigna una entrada x a una clase de salida y, el MLP encuentra la mejor aproximación a ese clasificador definiendo una asignación, y = f (x; θ) y aprendiendo los mejores parámetros θ para ella. Las redes MLP están compuestas de muchas funciones que están encadenadas juntas. Una red con tres funciones o capas formaría f (x) = f (3) (f (2) (f (1) (x))). Cada una de estas capas está compuesta de unidades que realizan una transformación afín de una suma lineal de entradas. Cada capa se representa como y = f (WxT + b). Donde f es la función de activación (cubierta a continuación), W es el conjunto de parámetros, o pesos, en la capa, x es el vector de entrada, que también puede ser la salida de la capa anterior, y b es el vector de polarización. Las capas de un MLP consisten en varias capas completamente conectadas porque cada unidad de una capa está conectada a todas las unidades de la capa anterior.

En un sistema de clasificación supervisado, cada vector de entrada está asociado con una etiqueta, o verdad fundamental, que define su clase o etiqueta de clase con los datos. La salida de la red proporciona un puntaje de clase, o predicción, para cada entrada. Para medir el rendimiento del clasificador, se define la función de pérdida. La pérdida será alta si la clase predicha no corresponde a la clase verdadera, de lo contrario será baja. A veces, el problema de sobreajuste y falta de ajuste se produce en el momento de entrenar al modelo. En este caso, nuestro modelo funciona muy bien en los datos de entrenamiento pero no en los datos de prueba. Para entrenar la red, se requiere un procedimiento de optimización para esto necesitamos una función de pérdida y un optimizador. Este procedimiento encontrará los valores para el conjunto de pesos, W, que minimiza la función de pérdida.

Una estrategia popular es inicializar los pesos a valores aleatorios y refinarlos iterativamente para obtener una pérdida menor. Este refinamiento se logra moviéndose en la dirección definida por el gradiente de la función de pérdida. Y es importante establecer una tasa de aprendizaje que defina la cantidad en que se mueve el algoritmo en cada iteración.

### 1.3.1 Función de activación

Las funciones de activación también conocidas como no linealidad, describen las relaciones de entrada-salida de forma no lineal. Esto le da al modelo poder para ser más flexible al describir relaciones arbitrarias. Estas son algunas de las funciones de activación populares Sigmoid, Relu y TanH.

### 1.3.2 Entrenando al modelo

Básicamente, hay tres pasos en la capacitación del modelo.
 1. Pase adelantado
 2. Calcular error o pérdida
 3. Pase hacia atrás

#### 1.3.2.1 Pase hacia adelante

En este paso de entrenamiento del modelo, simplemente pasamos la entrada al modelo y multiplicamos con pesos y agregamos sesgo en cada capa y encontramos la salida calculada del modelo.

#### 1.3.2.2 Calcular la pérdida

Cuando pasamos la instancia de datos (o un ejemplo) obtendremos algo de salida del modelo que se llama Salida predicha (pred_out) y tenemos la etiqueta con los datos que son salida real o salida esperada (Expect_out). En base a estos dos, calculamos la pérdida que tenemos que propagar hacia atrás (usando el algoritmo de propagación hacia atrás). Hay varias funciones de pérdida que utilizamos en función de nuestra producción y requisitos.

#### 1.3.2.3 Pase hacia atrás

Después de calcular la pérdida, propagamos la pérdida hacia atrás y actualizamos los pesos del modelo utilizando gradiente. Este es el paso principal en la formación del modelo. En este paso, los pesos se ajustarán de acuerdo con el flujo de gradiente en esa dirección.

# Capítulo II: Implementación

A lo largo de las pruebas que se realizarás en este proyecto se pretende usar el lenguaje de programación Scala, en conjunto con el framework Spark.

El mundo de Big Data evoluciona rápido. Siempre aparecen nuevas tecnologías que prometen gestionar y analizar grandes volúmenes de datos de una forma más rápida, más escalable y con unos coste de implementación y mantenimiento más baratos.

Existen muchas características que hacen de Spark una plataforma especial, pero podríamos englobar en cinco aspectos importantes: es una plataforma de código abierto con una comunidad muy activa; es una herramienta rápida; unificada; dispone de una consola interactiva cómoda para los desarrolladores; y también tiene una API para trabajar con los grandes datos.

1. Una plataforma de código abierto con una comunidad activa
Una de las propiedades más interesantes de una solución de código abierto es la actividad de su comunidad. Es la comunidad de desarrolladores la que mejora las características de la plataforma, y ayuda al resto de programadores a implementar soluciones o resolver problemas.

2. Una plataforma rápida 
Una de las primeras circunstancias que sorprenden de Spark es que, para ser una plataforma de código abierto, su velocidad es enorme, muy por encima de algunas soluciones propietario. ¿Por qué es tan rápida? Apache Spark permite a los programadores realizar operaciones sobre un gran volumen de datos en clústeres de forma rápida y con tolerancia a fallos. Cuando tenemos que manejar algoritmos, trabajar en memoria y no en disco mejora el rendimiento.

3. Una plataforma unificada para gestionar datos
Es una de las características más reconocibles de Apache Spark. Es una plataforma de plataformas. Un ‘todo en uno’ que agiliza mucho el funcionamiento y el mantenimiento de sus soluciones. Combina:
  - Spark SQL: permite la consulta de datos estructurados utilizando lenguaje SQL o una API, que se puede usar con Java, Scala, Python o R.
  - Spark Streaming: mientras MapReduce solo procesa datos en lotes, Spark tiene la posibilidad de gestionar grandes datos en tiempo real. Esto facilita que los datos se analicen según van entrando, sin tiempo de latencia y a través de un proceso de gestión en continuo movimiento.
  - MLlib (Machine Learning): esta herramienta contiene algoritmos que dotan a Apache Spark de muchas utilidades, como la regresión logística y máquinas de vectores de soporte (SVM); modelos de árbol de regresión bayesiana; técnicas de mínimos cuadrados; modelos de mezclas gaussianas; análisis de conglomerados de K medias; asignación latente de Dirichlet (LDA); descomposición en valores singulares (SVD); análisis de componentes principales (ACP); regresión lineal; regresión isotónica…
  - GraphX: es un framework de procesamiento gráfico. Proporciona una API para la elaboración de grafos con los datos. Primero fue un proyecto separado de AMPLab y Databricks de la Universidad de Berkeley, como Spark, pero posteriormente se unió a la Fundación de Software Apache.

4. Consola interactiva
Una de las ventajas de trabajar con Spark son las consolas interactivas que tiene para dos de los lenguajes con los que se puede programar, Scala (que se ejecuta en una máquina virtual Java- JVM) y Python. Estas consolas permiten analizar los datos de forma interactiva, con la conexión a los clústeres.

5. Una gran API para trabajar con los datos
Apache Spark tiene APIs nativas para los lenguajes de programación Scala, Python y Java. Este conjunto de APIs facilita a los programadores el desarrollo de aplicaciones en estas sintaxis, que se puedan ejecutar en la plataforma de código abierto. 

# Capítulo III: Resultados

## 3.1 Algoritmos

### 3.1.1 SVM (Support Vector Machine)

    // 15510506
    // Cabrera Reyes Ivan
    // Datos Masivos
    // Proyecto Integrador - Unidad 4
    // Support Vector Machine

    // Importar librerías
    import org.apache.spark.sql.SparkSession
    import org.apache.spark.ml.feature.VectorAssembler
    import org.apache.spark.ml.classification.LinearSVC
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

    // Crear una instancia de la sesión Spark
    val spark = SparkSession.builder().getOrCreate()

    // Cargar el archivo de datos
    val bankfull = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("bank-full.csv")

    // Mostrar datos
    bankfull.show(10)

    // Mostrar el esquema de los datos
    bankfull.printSchema()

    // Seleccionar las columas a trabajar
    // Se cambia la columa y por la columna x
    val cols = bankfull.select("balance","day","duration","campaign","pdays","previous","y").withColumn("x", when(col("y") === "yes", 1).when(col("y") === "no", 0))

    // Datafrane bank
    val bank = cols.select("balance","day","duration","campaign","pdays","previous","x").toDF()

    // Mostrar datos
    bank.show(5)
    bank.printSchema()

    // Array que contiene el nombre de las columnas
    val vectorCols = Array("balance","day","duration","campaign","pdays","previous","x")

    // Crear un VectorAssembler con los datos
    val Assembler = new VectorAssembler().setInputCols(vectorCols).setOutputCol("features")

    // Transformar los datos
    val data = Assembler.transform(bank).toDF()

    // Mostrar el resultado de la transformación
    data.show(10)

    // Tomar las columnas con las que se va a aplicar el algoritmo
    val cleanDf = data.select(col("x").as("label"),col("features"))

    cleanDf.show(10)
    cleanDf.printSchema()
    // ====================================================================
    //                         Support Vector Machine
    // ====================================================================

    // Nuevo modelo
    val svc = new LinearSVC().setMaxIter(10).setRegParam(0.1)

    // Dividir los datos en dos partes, una para entrenar el modelo y la otra para ver resultados
    val separador = cleanDf.randomSplit(Array(0.7, 0.3), seed = 9876L)
    val train = separador(0)
    val results = separador(1)

    // Entrenamiento del modelo
    val model = svc.fit(train)

    // Resultados
    val resultados = model.transform(results)

    // Declaración del evaluador
    val evaluador = new MulticlassClassificationEvaluator().setMetricName("accuracy")

    // Impresión de resultados
    println(s"Coeficientes: ${model.coefficients}")
    println(s"Intercepciones: ${model.intercept}")
    println(s"Grado de exactitud = ${evaluador.evaluate(resultados)}")

### 3.1.2 Logistic Regression (regresión logística)

    // 15510506
    // Cabrera Reyes Ivan
    // Datos Masivos
    // Proyecto Integrador - Unidad 4
    // Logistic Regression

    // Importar librerías
    import org.apache.spark.sql.SparkSession
    import org.apache.spark.ml.feature.VectorAssembler
    import org.apache.spark.ml.classification.LogisticRegression
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

    // Crear una instancia de la sesión Spark
    val spark = SparkSession.builder().getOrCreate()

    // Cargar el archivo de datos
    val bankfull = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("bank-full.csv")

    // Mostrar datos
    bankfull.show(10)

    // Mostrar el esquema de los datos
    bankfull.printSchema()

    // Seleccionar las columas a trabajar
    // Se cambia la columa y por la columna x
    val cols = bankfull.select("balance","day","duration","campaign","pdays","previous","y").withColumn("x", when(col("y") === "yes", 1).when(col("y") === "no", 0))

    // Datafrane bank
    val bank = cols.select("balance","day","duration","campaign","pdays","previous","x").toDF()

    // Mostrar datos
    bank.show(5)
    bank.printSchema()

    // Array que contiene el nombre de las columnas
    val vectorCols = Array("balance","day","duration","campaign","pdays","previous","x")

    // Crear un VectorAssembler con los datos
    val Assembler = new VectorAssembler().setInputCols(vectorCols).setOutputCol("features")

    // Transformar los datos
    val data = Assembler.transform(bank).toDF()

    // Mostrar el resultado de la transformación
    data.show(10)

    // Tomar las columnas con las que se va a aplicar el algoritmo
    val cleanDf = data.select(col("x").as("label"),col("features"))

    cleanDf.show(10)
    cleanDf.printSchema()
    // ====================================================================
    //                         Logistic Regression
    // ====================================================================

    // Nuevo modelo
    val lr = new LogisticRegression().setMaxIter(10).setRegParam(0.1)//.setElasticNetParam(0.8).setFamily("multinomial")

    // Dividir los datos en dos partes, una para entrenar el modelo y la otra para ver resultados
    val separador = cleanDf.randomSplit(Array(0.7, 0.3), seed = 9876L)
    val train = separador(0)
    val results = separador(1)

    // Entrenamiento del modelo
    val model = lr.fit(train)

    // Resultados
    val resultados = model.transform(results)

    // Declaración del evaluador
    val evaluador = new MulticlassClassificationEvaluator().setMetricName("accuracy")

    // Impresión de resultados
    println(s"Coeficientes: ${model.coefficients}")
    println(s"Intercepciones: ${model.intercept}")
    println(s"Grado de exactitud = ${evaluador.evaluate(resultados)}")

### 3.1.3 Multilayer perceptron (perceptrón multicapa)

    // 15510506
    // Cabrera Reyes Ivan
    // Datos Masivos
    // Proyecto Integrador - Unidad 4
    // Multilayer Perceptron

    // Importar librerías
    import org.apache.spark.sql.SparkSession
    import org.apache.spark.ml.feature.VectorAssembler
    import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

    // Crear una instancia de la sesión Spark
    val spark = SparkSession.builder().getOrCreate()

    // Cargar el archivo de datos
    val bankfull = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("bank-full.csv")

    // Mostrar datos
    bankfull.show(10)

    // Mostrar el esquema de los datos
    bankfull.printSchema()

    // Seleccionar las columas a trabajar
    // Se cambia la columa y por la columna x
    val cols = bankfull.select("balance","day","duration","campaign","pdays","previous","y").withColumn("x", when(col("y") === "yes", 1).when(col("y") === "no", 2))

    // Datafrane bank
    val bank = cols.select(col("balance"),col("day"),col("duration"),col("campaign"),col("pdays"),col("previous"),"x").toDF()

    // Mostrar datos
    bank.show(5)
    bank.printSchema()

    // Array que contiene el nombre de las columnas
    val vectorCols = Array("balance","day","duration","campaign","pdays","previous","x")

    // Crear un VectorAssembler con los datos
    val Assembler = new VectorAssembler().setInputCols(vectorCols).setOutputCol("features")

    // Transformar los datos
    val data = Assembler.transform(bank).toDF()

    // Mostrar el resultado de la transformación
    data.show(10)

    // Tomar las columnas con las que se va a aplicar el algoritmo
    val cleanDf = data.select(col("x").as("label"),col("features"))

    cleanDf.show(10)
    cleanDf.printSchema()
    // ====================================================================
    //                         Multilayer Perceptron
    // ====================================================================

    // Se toma un 30% de los datos para pruebas, usando la semilla 9876L
    val separador = cleanDf.randomSplit(Array(0.7, 0.3), seed = 9876L)
    val entrenar = separador(0)
    val pruebas = separador(1)

    // Se crea un Array donde se especifican las capas que tendrá el algoritmo
    // 3 de entrada, 4 y 4 intermedias y 3 de salida
    val capas = Array[Int](4, 3, 3)

    // Se declara un objeto de tipo MultilayerPerceptronClassifier y se le proporcionan los parámetros
    val entrenador = new MultilayerPerceptronClassifier().setLayers(capas).setBlockSize(128).setSeed(9876L).setMaxIter(100)

    // Entrenamiento del modelo
    val modelo = entrenador.fit(entrenar)

    // Calcular los resultados utilizando los datos de prueba
    val resultadoPrueba = modelo.transform(pruebas)
    resultadoPrueba.printSchema()
    val pe = resultadoPrueba.select(col("prediction"), col("label"))
    //pe.show()

    val evaluador = new MulticlassClassificationEvaluator().setMetricName("accuracy")

    //impresion de resultados
    println(s"Grado de exactitud = ${evaluador.evaluate(pe)}")

## 3.2 Tabla de resultados

    -----------------------------------------------------------------------------------------------------------------
    |        Algoritmo        |        Coeficientes        |        Intercepciones        |        Exactitud        |
    -----------------------------------------------------------------------------------------------------------------
    |                         |    [4.700711573871039E-6,  |                              |                         |
    |                         |    -0.013637817729395586,  |                              |                         |
    |                         |    3.443214816746768E-5,   |                              |                         |
    |   Logistic Regression   |    -0.027013036831088865,  |       -0.915873876656511     |           1.0           |
    |                         |    -6.556152022953873E-5,  |                              |                         |
    |                         |    -4.0643270651957166E-4, |                              |                         |
    |                         |    2.4059610867117147]     |                              |                         |
    -----------------------------------------------------------------------------------------------------------------
    |                         |    [1.2323986009141667E-5, |                              |                         |
    |                         |    -0.0018782933682339222, |                              |                         |
    |                         |    9.715565399414336E-4,   |                              |                         |
    |  Support Vector Machine |    -0.018985824897480408,  |      -3.3336194659477796     |    0.9999263839811543   |
    |                         |    6.883447363137954E-4,   |                              |                         |
    |                         |    0.016186822235579972,   |                              |                         |
    |                         |    3.590021847055572]      |                              |                         |
    -----------------------------------------------------------------------------------------------------------------
    |                         |                            |                              |                         |
    |                         |                            |                              |                         |
    |                         |                            |                              |                         |
    |   Multilayer Perceptron |         ----------         |          ----------          |    0.8887165854378969   |
    |                         |                            |                              |                         |
    |                         |                            |                              |                         |
    |                         |                            |                              |                         |
    -----------------------------------------------------------------------------------------------------------------
   
    Nota: La exactitud fue tomada como promedio en base a la ejecución de cada algoritmo 10 veces
 
# Conclusiones

Con base en lo observado a lo largo de las pruebas que se realizaron, es posible concluir que las variables de entrada en cada caso afectan significativamente los resultados.

La manera en la que cada algoritmo se comporta aprovecha de diferente manera los datos, pudiendo observar que para el ejemplo que se trató a lo largo del proyecto, el mejor algoritmo a la hora de la evaluación de exactitud fue Support Vector Machine, sin embargo, dadas las circunstancias bien pudo haber sido cualquiera de los otros dos.

En conclusión, cada algoritmo tiene características específicas que se deben aprovechar dependiendo los datos que se deseen tratar, ya que ésto afecta su rendimiento generando mejores o peores resultados dependiendo sea el caso que se deseen tratar, ya que ésto afecta su rendimiento generando mejores o peores resultados dependiendo sea el caso

# Referencias

1. Rohith Gandhi. (2018). Support Vector Machine - Introducción a los algoritmos de aprendizaje automático. Dic 2019, de Medium Sitio web: https://towardsdatascience.com/support-vector-machine-introduction-to-machine-learning-algorithms-934a444fca47
2. Apoorva Agrawal. (2107). Regresión logística. Simplificado.. Dic 2019, de Medium Sitio web: https://medium.com/data-science-group-iitr/logistic-regression-simplified-9b4efe801389
3. Nitin Kumar Kain. (2018). Comprensión del perceptrón multicapa (MLP). Dic 2109, de Medium Sitio web: https://medium.com/@AI_with_Kain/understanding-of-multilayer-perceptron-mlp-8f179c4a135f














