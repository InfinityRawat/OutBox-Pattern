package com.Transactional.OutboxPattern.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Transactional.OutboxPattern.Entity.Outbox;

public interface OutboxRepo extends JpaRepository<Outbox, Long>{
		
	 
}
