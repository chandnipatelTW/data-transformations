package readingData

import org.apache.spark.sql.SparkSession

object ReadingParquet {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Reading data from Parquet file with Spark App").getOrCreate()

    val filepath = if(args.isEmpty) "src/test/resources/parquetFile.parquet" else args(0)

    val uberDF = spark.read.parquet(filepath)

    uberDF.show()

    spark.stop()
  }

}
