package config;


import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class ConfigConsumer {
    Properties properties;

    public ConfigConsumer() {
        this.properties = setProps();
    }

    public Properties setProps() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.200:29092");
        props.put("group.id", "consumer-tutorial");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        return props;
    }
}
