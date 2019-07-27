package main

import org.apache.spark.sql.SparkSession

object ReadCSV {
    def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("ReadCSV").getOrCreate()
        val df = spark.read
            .option("header", true)
            .option("inferSchema", true)
            .csv("./data/samplecsv.csv")
        df.printSchema()
        df.show()
        spark.stop()
    }
}