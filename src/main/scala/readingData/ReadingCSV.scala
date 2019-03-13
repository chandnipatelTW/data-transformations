package readingData

import org.apache.spark.sql.SparkSession

object ReadingCSV {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("Read CSV Data with Spark App").getOrCreate()

    val filepath = if(args.isEmpty) "src/test/resources/samplecsv.csv" else args(0)

    val weatherDF = spark
      .read
      .option("header", true)
      .option("inferSchema", true)
      .csv(filepath)

    weatherDF.show()
    weatherDF.printSchema()

    spark.stop()
  }
}
