// 15510506
// Cabrera Reyes Ivan
// Datos Masivos
// Examen 01 - Unidad 3

// 1. Importar una simple sesión Spark. 
import org.apache.spark.sql.SparkSession

// 2. Utilice las lineas de código para minimizar errores 
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// 3. Cree una instancia de la sesión Spark
val spark = SparkSession.builder().getOrCreate()

// 4. Importar la librería de Kmeans para el algoritmo de agrupamiento. 
import org.apache.spark.ml.clustering.KMeans

// 5. Carga el dataset de Wholesale Customers Data 
val dataset = spark.read.option("header", "true").option("inferSchema","true")csv("Wholesale_customers_data.csv")

// 6. Seleccione las siguientes columnas: Fres, Milk, Grocery, Frozen, Detergents_Paper, Delicassen y llamar a este conjunto feature_data 
dataset.show()
dataset.printSchema()

val columns = dataset.select($"Fresh", $"Milk", $"Grocery", $"Frozen", $"Detergents_Paper",$"Delicassen")

// 7. Importar Vector Assembler y Vector 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

// 8. Crea un nuevo objeto Vector Assembler para las columnas de caracteristicas como un conjunto de entrada, recordando que no hay etiquetas 
val vAss = new VectorAssembler().setInputCols(Array("Fresh","Milk","Grocery","Frozen","Detergents_Paper","Delicassen")).setOutputCol("features")

// 9. Utilice el objeto assembler para transformar feature_data 
val train = vAss.transform(columns)

columns.show()

// 10. Crear un modelo Kmeans con K=3 
val k = new KMeans().setK(3).setSeed(12345L)
val model = k.fit(train)


// 11.Evalúe los grupos utilizando 

val evaluate = model.computeCost(train)
println(s"Within Set Sum of Squared Errors = $evaluate")

println("Cluster Centers: ")
model.clusterCenters.foreach(println)

// 12. ¿Cuáles son los nombres de las columnas? 
columns.columns