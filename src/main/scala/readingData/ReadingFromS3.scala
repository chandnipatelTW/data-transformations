package readingData

import org.apache.spark.sql.SparkSession

object ReadingFromS3 {
  def main(args: Array[String]): Unit = {

    val AWS_ACCESS_KEY = System.getenv("AWS_ACCESS_KEY")
    val AWS_SECRET_KEY = System.getenv("AWS_SECRET_KEY")
    val AWS_BUCKET_NAME =  if (!args.isEmpty) args(0) else "reading-data-from-s3-test-bucket"
    val AWS_ASSET_NAME = if (args.length >= 2) args(1) else "/big.txt"


    val spark = SparkSession.builder.appName("Read Text File from S3 with Spark").getOrCreate()
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", AWS_ACCESS_KEY)
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", AWS_SECRET_KEY)

    val wordsDF = spark.read.text("s3a://" + AWS_BUCKET_NAME + AWS_ASSET_NAME)
    wordsDF.show()

    spark.stop()
  }
}
