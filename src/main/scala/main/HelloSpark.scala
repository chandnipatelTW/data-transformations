package main

import org.apache.spark.sql.SparkSession

object HelloSpark {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("Hello Spark App").getOrCreate()
    val text = spark.read.text("./data/sampletext.txt")
    text.printSchema()
    spark.stop()
  }
}
