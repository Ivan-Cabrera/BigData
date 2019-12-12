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