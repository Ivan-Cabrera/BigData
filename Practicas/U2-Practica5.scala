// 15510506
// Ivan Cabrera Reyes
// Practice 5
// Linear Support Vector Machine

// Import libraries
import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.sql.SparkSession

// Create a SparkSession
val spark = SparkSession.builder().getOrCreate()

// Load data and transform to DataFrame
val training = spark.read.format("libsvm").load("data/mllib/sample_libsvm_data.txt")

// Create a LinearSVCModel
val lsvc = new LinearSVC()
  .setMaxIter(10)
  .setRegParam(0.1)

// Fit the LinearSVCModel
val lsvcModel = lsvc.fit(training)

// Print the coefficients and intercept for linear svc
println(s"Coefficients: ${lsvcModel.coefficients} Intercept: ${lsvcModel.intercept}")