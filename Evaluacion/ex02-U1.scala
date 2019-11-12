// 15510506
// Cabrera Reyes Ivan
// Datos Masivos
// Examen 02 - Unidad 1

// Comienzo de una sesion simple de Spark
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

// Cargar el archivo Netflix Stock CSV
val df = spark.read.option("header", "true").option("inferSchema", "true").csv("Netflix_2011_2016.csv")

// Nombre de las columnas
df.columns

// Esquema del DataFrame
df.printSchema()

// 5 primeras filas
df.head(5)

// Describir el DataFrame
df.describe().show()

// Nuevo DataFrame
val df2 = df.withColumn("HV Radio", df("Volume")/df("High"))

// Significado de la columna Close
// Es el valor de las acciones al termino (cierre) del dia 

// Minimo y Maximo de la columna Volumen
df.select(min("Volume")).show()
df.select(max("Volume")).show()

// Dias que la columna Close fue inferior a 600
val close = df.filter($"Close"<600).count()
println("La columna Close fue inferior a 600 en " + close +" ocasiones")

// Porcentaje de tiempo que la columna High fue mayor a 500
val porcent = (df.filter($"High">500).count() * 100)/df.count()
println("La columna High fue mayor a 500 un "+ porcent +"% de las veces")

// Correlacion de Pearson entre la columna High y la columna Volume
df.select(corr("High", "Volume")).show()

// Maximo de la columna High por anio
df.groupBy(year(df("Date"))).max("High").orderBy(year(df("Date"))).show()


// Promedio de la columna Close por cada mes del calendario
df.groupBy(month(df("Date"))).avg("Close").orderBy(month(df("Date"))).show()
