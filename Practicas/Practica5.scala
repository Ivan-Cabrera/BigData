
// Importar libreria SparkSession
import org.apache.spark.sql.SparkSession

// Instanciar la libreria SparSession
val spark = SparkSession.builder().getOrCreate()

// Leer el DataFrame
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Test01.csv")

// Seleccionar una sola columna
df.select("Time").show()
df.select("CO").show()
df.select("Humidity").show()
df.select("Temperature").show()
df.select("Flow rate").show()
df.select("Heater voltaje").show()

// Seleccionar dos columnas

df.select($"Time", $"CO").show()
df.select($"Time", $"Humidity").show()
df.select($"Time", $"Temperature").show()
df.select($"Time", $"Flow rate").show()
df.select($"Time", $"Heater voltaje").show()

// Seleccionar tres columnas

df.select($"Time", $"CO", $"Humidity").show()
df.select($"Time", $"CO", $"Temperature").show()
df.select($"Time", $"CO", $"Flow rate").show()
df.select($"Time", $"CO", $"Heater voltaje").show()

// Seleccionar cuatro columnas

df.select($"Time", $"CO", $"Humidity", $"Temperature").show()
df.select($"Time", $"CO", $"Humidity", $"Flow rate").show()
df.select($"Time", $"CO", $"Humidity", $"Heater voltaje").show()


// Describir el DataFrame

df.describe().show()

// Imprimir las columnas del DataFrame

df.columns

// Imprimir el esquema del DataFrame

df.printSchema()
