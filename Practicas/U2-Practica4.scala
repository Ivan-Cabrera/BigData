// 15510506
// Ivan Cabrera Reyes
// Practice 4
// Multilayer perceptron classifier

// Import libraries
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.SparkSession

// Create a SparkSession
val spark = SparkSession.builder().getOrCreate()

// Load data and transform to DataFrame
val data = spark.read.format("libsvm").load("data/mllib/sample_multiclass_classification_data.txt")

// Split the data into train and test sets with seed 1234L
val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)

// Input layer of size 4 (features), second layer of size 5, third layerof size 4 and output layer of size 3 (classes)
val layers = Array[Int](4, 5, 4, 3)

// Create A MultilayerPerceptronClassifier
val trainer = new MultilayerPerceptronClassifier()
  .setLayers(layers)
  .setBlockSize(128)
  .setSeed(1234L)
  .setMaxIter(100)

// Fit the MultilayerPerceptronClassifier
val model = trainer.fit(train)

// Calculate accuracy and make predictions
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator()
  .setMetricName("accuracy")

// Print results
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")