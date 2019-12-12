// 15510506
// Ivan Cabrera Reyes
// Practice 6
// One-vs-Rest classifier (a.k.a. One-vs-All)

// Import libraries
import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.SparkSession

// Create a SparkSession
val spark = SparkSession.builder().getOrCreate()

// Load data and transform to DataFrame
val inputData = spark.read.format("libsvm")
  .load("data/mllib/sample_multiclass_classification_data.txt")


// Split the data into training and test sets (80% training and 20% for tests).
val Array(train, test) = inputData.randomSplit(Array(0.8, 0.2))

// Create the LogisticRegression classifier
val classifier = new LogisticRegression()
  .setMaxIter(10)
  .setTol(1E-6)
  .setFitIntercept(true)

// Create the OneVsRest Classifier.
val ovr = new OneVsRest().setClassifier(classifier)

// Fit ovrModel.
val ovrModel = ovr.fit(train)

// Make predictions.
val predictions = ovrModel.transform(test)

// Create the MulticlassClassificationEvaluator
val evaluator = new MulticlassClassificationEvaluator()
  .setMetricName("accuracy")

// Calculate accuray and print results
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1 - accuracy}")