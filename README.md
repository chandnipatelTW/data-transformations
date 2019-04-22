# Basic Repo for working with Spark + Scala

The purpose of this repo is to make sure you have everything set up to build and run a spark project locally.

## Pre-requisites
Please make sure you have the following installed
* Java 8
* Scala 2.11
* Sbt 1.1.x
* Apache Spark 2.4 with ability to run spark-submit locally

## Setup for local building and testing
* Clone this repo
* Build: sbt assembly
* Test: sbt test

Please confirm that all of the test pass.

## Setup for local run with spark-submit
After running sbt assembly run from the root directory
```
spark-submit target/scala-2.12/data-transformations-assembly-0.1.jar 
```

Confirm that you see "Hello Spark" in the output.


If all the test passed locally and "Hello Spark" was in the output than your environment is set up and ready for a TW Data Engineering coding interview.


## Reading Data with Spark
In the reading data folder there are four objects that show how to read CSV, Parquet or text data, and how to read from S3.  
Run the following commands to execute the solutions to the reading data exercises:

###Reading Text Files
```
spark-submit --master local --class readingData.ReadingText target/scala-2.12/data-transformations-assembly-0.1.jar 

```

###Reading CSV Files
```
spark-submit --master local --class readingData.ReadingCSV target/scala-2.12/data-transformations-assembly-0.1.jar 

```

###Reading Parquet Files
```
spark-submit --master local --class readingData.ReadingParquet target/scala-2.12/data-transformations-assembly-0.1.jar 

```

###Reading Text Files from S3
Note that in order to run reading from S3, you will have to create your own s3 bucket, upload data to it, and configure environment variables and pass in arguments to your spark-submit command.
```
export AWS_ACCESS_KEY=MYACCESSEKEY
export AWS_SECRET_KEY=myseceretkey293kfelkjweilejrlwk3
spark-submit --master local --class readingData.ReadingFromS3 target/scala-2.12/data-transformations-assembly-0.1.jar "mybucketname" "/filename" 

```
Read the following link to get more data on how to set your code to read from S3
https://spark.apache.org/docs/2.3.0/cloud-integration.html
