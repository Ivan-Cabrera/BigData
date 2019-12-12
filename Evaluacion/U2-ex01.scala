// 15510506
// Cabrera Reyes Ivan
// Datos Masivos
// Examen 01 - Unidad 2

// Importar librerias para sesion de Spark
import org.apache.spark.sql.SparkSession
import spark.implicits._

// Importar librerias para poder usar Multilayer Perceptron
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

// Importar librerías para poder usar arreglos (vectores)
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.feature.VectorAssembler

// Importar librerias para poder usar conversiones de tipo
import org.apache.spark.ml.attribute.Attribute
import org.apache.spark.ml.feature.IndexToString
import org.apache.spark.ml.feature.StringIndexer

// Create a SparkSession
val spark = SparkSession.builder().appName("Examen Unidad 2").getOrCreate()

// Leer el archivo Iris
val csv = spark.read.format("csv").option("sep", ",").option("inferSchema", "true").option("header", "true").load("iris.csv")

// Mostrar el esquema de los datos
csv.printSchema()

// Crear la columna etiqueta, para transformar los string de la columna species en numeros
val i = new StringIndexer().setInputCol("species").setOutputCol("etiqueta").fit(csv)

// Se transforman los datos en un nuevo DataFrame con la nueva columna etiqueta
val ix = i.transform(csv)
ix.show()

// Crear un nuevo DataFrame solo con las columnas que se necesitan
val data = ix.select(col("sepal_length").as("sl"), col("sepal_width").as("sw"), col("petal_length").as("pl"), col("petal_width").as("pw"), col("etiqueta").as("label"))  
data.show(5)

// Crear un array con las columnas necesarias
val features = Array("sl","sw","pl","pw")

// Declarar el vector, pasando como parametro las columnas
val vector = new VectorAssembler().setInputCols(features).setOutputCol("features")

// Transformar los datos de entrada en un nuevo DataFrame, que es con el que se trabajará
val df = vector.transform(data)

val resultado = df.select("label","features")
resultado.show()

// Aqui comienza el algotito Multilayer Perceptron

// Se toma un 30% de los datos para pruebas, usando la semilla 9876L
val separador = resultado.randomSplit(Array(0.7, 0.3), seed = 9876L)
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

// Cerrar la sesion actual de Spark
spark.close()