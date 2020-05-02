package org.kafkawithjava;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    public static String consumerData() {
        Properties properties=new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer",StringDeserializer.class.getName());
        properties.put("group.id","test");

        KafkaConsumer<String,String> kafkaConsumer=new KafkaConsumer<String, String>(properties);

        kafkaConsumer.subscribe(Arrays.asList("first"));

        ConsumerRecords<String,String> records=kafkaConsumer.poll(100);
        String result="";
        for(ConsumerRecord<String,String> record:records){
            result+=record.toString()+"\n";
        }
        return result;
    }

}
