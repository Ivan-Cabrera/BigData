/*Importamos la libreria Logistic Regression y SparkSession*/
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
/*Implementación de Error reporting*/
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
/*Inicializamos la sesión de spark*/
val spark = SparkSession.builder().getOrCreate()
/*Creamos la variable "data" para leer el archivo CSV llamado
"Advertising"*/
val data =
spark.read.option("header","true").option("inferSchema",
"true").format("csv").load("advertising.csv")
/*Mostramos los datos e imprimimos el Schema de nuestro DataSet*/
data.show()
data.printSchema()
/*Despliegue los datos*/
data.head(1)
/*Creamos la variable colnames la cual contendrá en un arreglo de
string la información de la primera columna*/
val colnames = data.columns
/*Creacion de la variable fristrow la cual contendra el contendido
de la primera columna de datos*/
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)){
println(colnames(ind))
println(firstrow(ind))
println("\n")
}

/*Creamos una nueva columna llamada "Hour" del Timestamp*/
val timedata = data.withColumn("Hour",hour(data("Timestamp")))
/*Se renombra la columna "Clicked on Ad" a "label"*/
val logregdata = timedata.select(data("Clicked on Ad").as("label")
,$"Daily Time Spent on Site", $"Age", $"Area Income", $"Daily
Internet Usage", $"Hour", $"Male")
/* Visualización*/
logregdata.show()
/*Importación de las librerias VectorAssembler y Vectors*/
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
/*Creación de un nuevo objecto VectorAssembler llamado assembler
para los feature las cuales serán las columnas restantes del
dataset*/
val assembler = (new VectorAssembler().setInputCols(Array("Daily
Time Spent on Site", "Age","Area Income","Daily Internet
Usage","Hour","Male")).setOutputCol("features"))
/*Utilizamos randomSplit para crear datos de entrenamiento con 70%
y de prueba 30% con los que estará interactuando nuestro
algoritmo*/
val Array(training, test) = logregdata.randomSplit(Array(0.7,
0.3), seed = 12345)
/* Importación de la libreria de Pipeline*/
import org.apache.spark.ml.Pipeline
/*Creación de un nuevo objeto de LogisticRegression llamado lr*/
val lr = new LogisticRegression()
/*Creación de un nuevo pipeline con los elementos: assembler la
cual es nuestras factures, lr duentro objeto de
LogisticRegression*/
val pipeline = new Pipeline().setStages(Array(assembler, lr))

/*Creación de la variable model la cual contendrá el elemento de
pipeline el cual contendrá un ajuste (fit) para el conjunto que
nos encontramos entrenando*/
val model = pipeline.fit(training)
/* Resultado del modelo con la transformación de los datos de
prueba.*/
val results = model.transform(test)
results.show()
/*Importamos la librería de MulticlassMetrics*/
import org.apache.spark.mllib.evaluation.MulticlassMetrics
/*Convertimos los resultados de la prueba (test) en RDD */
val predictionAndLabels =
results.select($"prediction",$"label").as[(Double, Double)].rdd
/*Inicializamos el objeto MulticlassMetrics con el parametro
predictionAndLabels */
val metrics = new MulticlassMetrics(predictionAndLabels)
/* Impresión de la matriz de confusión*/
println("Confusion matrix:")
println(metrics.confusionMatrix)
/* Imprimimos la exactitud de nuestra predicción*/
metrics.accuracy