package com.Transactional.OutboxPattern.Util;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaUtil {
	
	private KafkaTemplate<String, Object> temp;
	
	
	public KafkaUtil(KafkaTemplate<String, Object> temp) {
		super();
		this.temp = temp;
	}


	public void publishToTopic(String outbox) {
			
		CompletableFuture<SendResult<String, Object>> send = temp.send("order_topic",outbox);
		
		send.whenComplete((result,ex)->{
			if(ex!=null) {
				System.out.println(ex.getLocalizedMessage());
			}else {
				log.info("result info {}",result.getProducerRecord());
				System.out.println("Record is published");
				System.out.println(result.getRecordMetadata());
			}
		});
	}
	
}
