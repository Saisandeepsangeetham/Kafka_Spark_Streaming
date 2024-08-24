package Consumers;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.from_json;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class SparkStructuredStreamingDeliveryFee{
    public static void main(String[] args) throws TimeoutException, StreamingQueryException {

        SparkConf conf = new SparkConf().setMaster("local").setAppName("SparkStructuredStreamingWithKafka");
        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();
        spark.sparkContext().setLogLevel("ERROR");

        List<StructField> coordFields = new ArrayList<StructField>();
        coordFields.add(DataTypes.createStructField("lat", DataTypes.DoubleType, true));
        coordFields.add(DataTypes.createStructField("lon", DataTypes.DoubleType, true));

        List<StructField> fields = new ArrayList<StructField>();

        fields.add(DataTypes.createStructField("orderId", DataTypes.StringType, true));

        fields.add(DataTypes.createStructField("deliveryPersonId", DataTypes.StringType, true));
        fields.add(DataTypes.createStructField("deliveryPersonAge", DataTypes.IntegerType, true));
        fields.add(DataTypes.createStructField("personRating", DataTypes.DoubleType, true));
        fields.add(DataTypes.createStructField("deliveryLatitude", DataTypes.DoubleType, true));
        fields.add(DataTypes.createStructField("deliveryLongitude", DataTypes.DoubleType, true));
        fields.add(DataTypes.createStructField("restaurantLatitude", DataTypes.DoubleType, true));
        fields.add(DataTypes.createStructField("restaurantLongitude", DataTypes.DoubleType, true));
        fields.add(DataTypes.createStructField("orderDate", DataTypes.StringType, true));
        fields.add(DataTypes.createStructField("orderTime", DataTypes.StringType, true));
        fields.add(DataTypes.createStructField("deliveryDate", DataTypes.StringType, true));
        fields.add(DataTypes.createStructField("deliveryTime", DataTypes.StringType, true));
        fields.add(DataTypes.createStructField("orderPrice", DataTypes.DoubleType, true));
        fields.add(DataTypes.createStructField("deliveryFee", DataTypes.DoubleType, true));
        fields.add(DataTypes.createStructField("paymentMethod", DataTypes.StringType, true));
        fields.add(DataTypes.createStructField("customerId", DataTypes.StringType, true));
        fields.add(DataTypes.createStructField("restaurantId", DataTypes.StringType, true));
        StructType structType = DataTypes.createStructType(fields);


        Dataset<Row> df = spark
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("subscribe", "test")
                .load();
        Dataset<Row> res = df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
                .withColumn("value", from_json(col("value"), structType))
                .select(col("value.*"));

        res.createOrReplaceTempView("delivery");

        spark.sql("select deliveryPersonId,deliveryFee from delivery where deliveryFee < 20 ")
                .writeStream()
                .format("console")
                .outputMode(OutputMode.Append())
                .start()
                .awaitTermination();

    }
}