package main

import org.apache.spark.sql.SparkSession
import com.amazonaws.auth.AWSCredentialsProviderChain
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.auth.profile.ProfilesConfigFile

object ReadFromS3 {
  def main(args: Array[String]): Unit = {
    val configFile = new ProfilesConfigFile("/Users/dmortime/.aws/credentials")
    val credentialsProvider = new ProfileCredentialsProvider(configFile, "default")
    val awsCredentialsProvider = new AWSCredentialsProviderChain(credentialsProvider)
    val awsCredentials = awsCredentialsProvider.getCredentials()
    val spark = SparkSession.builder.appName("ReadParquet").getOrCreate()

    val keyId = awsCredentials.getAWSAccessKeyId()
    val secret = awsCredentials.getAWSSecretKey()

    // spark.sparkContext.hadoopConfiguration.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", keyId)
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", secret)

    println(keyId)
    println(secret)
    // spark.sparkContext.hadoopConfiguration.set("fs.s3a.endpoint", "s3.eu-west-2.amazonaws.com")

    val s3Path = "s3a://data-engineering-201-ireland/test-data/samplecsv.csv"

    val df = spark.read
        // .option("header", "true")
        // .option("inferSchema", "true")
        .csv(s3Path)
    df.printSchema()
    df.show()
    spark.stop()
  }
}
