package com.example.streams.generation;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

public class SparkSqlExample {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Spark-Sql-Example");
        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();
        Dataset<Row> df = spark.read().json("food-delivery-data.json");
        df.printSchema();
        df.createOrReplaceTempView("delivery");
        Dataset<Row> res = spark.sql("select count(*) as cash_payers from delivery  where paymentMethod='cash'");
        res.write()
                .mode(SaveMode.Overwrite)
                .json("paytm-trip-info");
        Dataset<Row> res1 = spark.sql("select count(*) as UPI_payers from delivery where paymentMethod != 'cash'");
        res1.write()
                .mode(SaveMode.Append)
                .json("paytm-trip-info");

        Dataset<Row> res2 = spark.sql("select deliveryPersonId,deliveryFee from delivery where deliveryFee < 20 ");
        res2.write()
                .mode(SaveMode.Append)
                .json("paytm-trip-info");

        Dataset<Row> res3 = spark.sql("select avg(deliveryPersonAge) as Average from delivery");
        res3.write()
                .mode(SaveMode.Append)
                .json("paytm-trip-info");
    }
}
