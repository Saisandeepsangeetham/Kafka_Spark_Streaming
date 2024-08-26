
# Big Data Kafka and Spark-Food Delivery Streaming.

This project demonstrates how to create and manage a streaming data pipeline for a food delivery management system using Apache Kafka and Apache Spark. The pipeline includes generating random sample data, sending it to a Kafka producer, and processing the data using Spark SQL for various analytics.




## Prerequisites

1. Apache Kafka: Ensure Kafka is installed and running on your machine. You can download it from [Apache Kafka](https://kafka.apache.org/).
2. Apache Spark: Spark should also be installed on your machine. You can download it from [Apache Spark Downloads](https://spark.apache.org/downloads.html).
3. Java Development Kit (JDK): Required for both Kafka and Spark. Install from [Oracle](https://www.oracle.com/java/technologies/downloads/?er=221886) or use OpenJDK.
4. Intellij/Eclipse IDE: Required for running the Maven project. prefared to use for better results.

## Setting Up Kafka.
1. Start Zookeeper: Before starting Kafka, you need to run Zookeeper. Use the following command to start Zookeeper.
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```
2.Start Kafka Server: Once Zookeeper is running, start the Kafka server with the command below:
```bash
bin/kafka-server-start.sh config/server.properties
```
3. Create Kafka Topic: Create a Kafka topic named food_delivery_stream for streaming data using the following command:
```bash
bin/kafka-topics.sh --create --topic test --bootstrap-server localhost:<bootstrap port> --replication-factor 1 --partitions 1
```

    
## Usage
To use this project, follow these steps to clone the repository, build the project, and run the necessary files to generate and consume data.

1. **Clone the Repository** <br>
First, clone the repository to your local machine using Git:
```bash
git clone https://github.com/Saisandeepsangeetham/your-repo-name.git
cd your-repo-name
```
2. **Run the Kafka Consumers** <br>
Navigate to the target/classes/Consumers directory and run the consumer files to start listening for Kafka streams:

```bash
cd src/main/java/Consumers/
```
3. **Generate Random Data and Send to Kafka** <br>
 Now, run the file that generates random data and sends it to the Kafka topic. Navigate to the directory where the data generation file is located:
```bash
cd src/main/java/com/example/streams/generation/
```
This will start generating random data for the food delivery management system and send it to the Kafka topic test.

4. **View Spark SQL Outputs** <br>
Once the data generation is running, the Kafka consumer, will start processing the data. The Spark SQL outputs and analytics will be displayed in the terminal where you ran the consumer files.

You can see various analytics in the terminal, such as:

- List of UPI payers.
- Orders with a delivery fee of less than 20.
- Delivery times.
- Order count for each month.
Make sure all consumer processes are running simultaneously to observe the real-time streaming and processing of data.

5. **Analyze Structured Streaming Data** <br>
To analyze the structured streaming data, you can use the Apache Spark Web UI. This UI provides detailed information about the Spark jobs, including:

- Streaming query status: Displays the progress of running streaming queries.
- Job details: Shows information about completed and running jobs.
- Environment and Executors: Provides details about the cluster environment and the status of executors.
To access the Spark Web UI, open your web browser and go to (http://localhost:4040.)

Make sure that the Spark application is running; otherwise, the UI will not be accessible.

## Learning Objectives
- Understand how to set up and run Apache Kafka for streaming data.
- Learn how to produce and consume streaming data using Kafka with Java.
- Gain practical experience in using Apache Spark SQL with Java to process and analyze streaming data.
- Perform basic data analytics on streaming data for a food delivery management system.



