package service;

import config.ConfigConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);
    ConfigConsumer configConsumer = new ConfigConsumer();

    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configConsumer.setProps());

    public void read() {
        log.info("TRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        consumer.subscribe(Arrays.asList("IN_TOPIC"));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records)
                    log.info("key = [{}], value = {}",
                            record.key(),
                            record.value());
            }
        } finally {
            consumer.close();
        }
    }

    ;
}
