package readingData

import org.apache.spark.sql.SparkSession

object ReadingText {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("Read Text File with Spark").getOrCreate()

    val filepath = if(args.length==0) "src/test/resources/sampletext.txt" else args(0)

    val text = spark.read.text(filepath)

    text.show()

    spark.stop()
  }
}
