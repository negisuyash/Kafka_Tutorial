package org.kafkawithjava;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {

        //Creating properties
        String bootstrapServers="localhost:9092";
        Properties properties=new Properties();
        properties.put("bootstrap.servers",bootstrapServers);
        properties.put("key.serializer",StringSerializer.class.getName());
        properties.put("value.serializer",StringSerializer.class.getName());

        //Creating Producer
        KafkaProducer<String,String> firstProducer=new KafkaProducer<String,String>(properties);

        ProducerRecord<String,String> record=new ProducerRecord<String, String>("first","Pussy fuck");

        firstProducer.send(record);
        System.out.println("Record sent");
        firstProducer.flush();
        firstProducer.close();

        System.out.println(Consumer.consumerData());

    }
}
