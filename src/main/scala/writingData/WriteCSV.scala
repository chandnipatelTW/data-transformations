package writingData

import org.apache.spark.sql.SparkSession

object WriteCSV {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Spark App to Write CSV").getOrCreate()
    val weatherDF = spark.read
      .option("header", true)
      .option("inferSchema", true)
      .csv("./src/main/resources/samplecsv.csv")

    weatherDF.write
      .option("header", true)
      .csv("./target/output/weather")

    spark.stop()
  }
}
