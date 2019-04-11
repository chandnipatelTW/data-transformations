package writingData

import org.apache.spark.sql.SparkSession

object WriteParquet {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Spark App to Write Parquet").getOrCreate()
    val weatherDF = spark.read
      .option("header",true)
      .option("inferSchema",true)
      .csv("./src/main/resources/samplecsv.csv")

    weatherDF.write
      .option("compression","snappy")
      .parquet("./target/output/weather.parquet")

    spark.stop()
  }
}
