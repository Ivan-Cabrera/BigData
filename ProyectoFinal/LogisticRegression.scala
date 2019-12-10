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
