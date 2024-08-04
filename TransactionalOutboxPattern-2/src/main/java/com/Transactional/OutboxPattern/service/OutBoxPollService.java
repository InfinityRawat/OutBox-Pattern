package com.Transactional.OutboxPattern.service;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.Transactional.OutboxPattern.Entity.Outbox;
import com.Transactional.OutboxPattern.Repository.OutboxRepo;
import com.Transactional.OutboxPattern.Util.KafkaUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@EnableScheduling
@Slf4j
public class OutBoxPollService {
	
	private OutboxRepo repo;
	
	private KafkaUtil kafka;
	

	
	public OutBoxPollService(OutboxRepo repo, KafkaUtil kafka) {
		super();
		this.repo = repo;
		this.kafka = kafka;
	}



	@Scheduled(fixedRate = 6000)
	public void pollOutBoxMessageAndPublish() {
		List<Outbox> byProcessedFalse = repo.findByProcessedFalse();
		
		log.info("processed false records {}",byProcessedFalse);
		
		byProcessedFalse.forEach((topic)->{
			try {
				kafka.publishToTopic(topic.getPayload());
				topic.setProcessed(true);
				repo.save(topic); 
			}
			catch(Exception ex) {
				System.out.println(ex.getLocalizedMessage());
			}
		});
	}
}
