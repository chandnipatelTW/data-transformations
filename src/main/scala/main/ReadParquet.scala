package main

import org.apache.spark.sql.SparkSession

object ReadParquet {
    def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("ReadParquet").getOrCreate()
        val df = spark.read
            .parquet("./data/parquetFile.parquet")
        df.printSchema()
        df.show()
        spark.stop()
    }
}