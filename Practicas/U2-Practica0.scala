// 15510506
// Ivan Cabrera Reyes
// Practice 0
// Basic Stadistics

/*
    =================================================================================================
                                                    Correlation
    =================================================================================================
*/

// Import libraries
import org.apache.spark.ml.linalg.{Matrix, Vectors}
import org.apache.spark.ml.stat.Correlation
import org.apache.spark.sql.Row

// Create a Seq
val data = Seq(
  Vectors.sparse(4, Seq((0, 1.0), (3, -2.0))),
  Vectors.dense(4.0, 5.0, 0.0, 3.0),
  Vectors.dense(6.0, 7.0, 0.0, 8.0),
  Vectors.sparse(4, Seq((0, 9.0), (3, 1.0)))
)

// Make a DataFrame with the Seq
val df = data.map(Tuple1.apply).toDF("features")

// Calculate and print Pearson Correlation
val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
println(s"Pearson correlation matrix:\n $coeff1")

// Calculate and print Spearman Correlation
val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
println(s"Spearman correlation matrix:\n $coeff2")

/*
    =================================================================================================
                                            Hypothesis testing
    =================================================================================================
*/

// Import libraries
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.ChiSquareTest

// Create a Seq
val data = Seq(
  (0.0, Vectors.dense(0.5, 10.0)),
  (0.0, Vectors.dense(1.5, 20.0)),
  (1.0, Vectors.dense(1.5, 30.0)),
  (0.0, Vectors.dense(3.5, 30.0)),
  (0.0, Vectors.dense(3.5, 40.0)),
  (1.0, Vectors.dense(3.5, 40.0))
)

// Make a DataFrame with the Seq
val df = data.toDF("label", "features")

// Calculate ChiSquareTest with the DataFrame
val chi = ChiSquareTest.test(df, "features", "label").head

// Show results
println(s"pValues = ${chi.getAs[Vector](0)}")
println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
println(s"statistics ${chi.getAs[Vector](2)}")


/*
    =================================================================================================
                                            Hypothesis testing
    =================================================================================================
*/

// Import libraries
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.Summarizer

// Create a Seq
val data = Seq(
  (Vectors.dense(2.0, 3.0, 5.0), 1.0),
  (Vectors.dense(4.0, 6.0, 7.0), 2.0)
)

// Make a DataFrame with the Seq
val df = data.toDF("features", "weight")

// Calculate mean and variance from DataFrame columns using weight column
val (meanVal, varianceVal) = df.select(metrics("mean", "variance")
  .summary($"features", $"weight").as("summary"))
  .select("summary.mean", "summary.variance")
  .as[(Vector, Vector)].first()

// Show results
println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")

// Calculate mean and variance from DataFrame columns without weight column
val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features"))
  .as[(Vector, Vector)].first()

// Show results
println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}")