// 15510506
// Ivan Cabrera Reyes
// Practice 7
// Naive Bayes

// Import libraries
import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.SparkSession
  
// Create a SparkSession
val spark = SparkSession.builder().getOrCreate()
    
// Load data and transform to DataFrame
val data = spark.read.format("libsvm").load("iris_libsvm.txt")
   
// Split the data into train and test sets with seed 1234L
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3), seed = 2229L)

// Show TrainingData
trainingData.show()

// Fit the NaiveBayesModel.
val model = new NaiveBayes().fit(trainingData)

// Make and show predictions
val predictions = model.transform(testData)
predictions.show()

// Select (prediction, true label) and compute test error
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")

// Calculate accuracy
val accuracy = evaluator.evaluate(predictions)
    
// Print results
println(s"Test set accuracy = $accuracy")
