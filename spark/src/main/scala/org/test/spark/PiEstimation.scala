package org.test.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object PiEstimation {
  def main(args: Array[String]) = {

//    def getCurrentDirectory = new java.io.File(".").getCanonicalPath
//    val hadophome = System.getProperty("hadoop.home.dir")
//    println(hadophome)
//    System.setProperty("hadoop.home.dir", "E:\\Softs\\Hadoop2.7.1");
//    println(System.getProperty("hadoop.home.dir"))

    //Start the Spark context
    val conf = new SparkConf()
      .setAppName("PiEstimation")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val NUM_SAMPLES = 1000

    val count = sc.parallelize(1 to NUM_SAMPLES).map { i =>
      val x = Math.random()
      val y = Math.random()
      if (x * x + y * y < 1) 1 else 0
    }.reduce(_ + _)
    println("Pi is roughly " + 4.0 * count / NUM_SAMPLES)

    //Stop the Spark context
    sc.stop

  }
}