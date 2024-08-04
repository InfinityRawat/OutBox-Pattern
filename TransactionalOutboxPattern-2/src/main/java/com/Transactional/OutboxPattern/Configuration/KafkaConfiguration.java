package com.Transactional.OutboxPattern.Configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfiguration {
	
		@Bean
		NewTopic topic() {
			return new NewTopic("order_topic", 2,(short)1);
		}
		
		@Bean
		 ProducerFactory<String, Object> factory(){
				ProducerFactory<String,Object> fact = new DefaultKafkaProducerFactory<>(configs());
				return fact;
		}

		
		private Map<String,Object> configs() {	
				
			Map<String,Object> conf = new HashMap<>();
			conf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
			conf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
			conf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
			return conf;
		}
		
		@Bean
		KafkaTemplate<String, Object> template(){
			KafkaTemplate<String, Object> temp = new KafkaTemplate<>(factory());
			return temp;
		}
}
