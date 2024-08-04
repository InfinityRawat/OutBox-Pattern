package com.Transactional.OutboxPattern.Service;

import org.springframework.stereotype.Service;

import com.Transactional.OutboxPattern.DTO.OrderDTO;
import com.Transactional.OutboxPattern.Entity.Order;
import com.Transactional.OutboxPattern.Entity.Outbox;
import com.Transactional.OutboxPattern.Repository.OrderServiceRepo;
import com.Transactional.OutboxPattern.Repository.OutboxRepo;
import com.Transactional.OutboxPattern.Utils.OrderMapper;
import com.Transactional.OutboxPattern.Utils.OrderToOutbox;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	private OrderServiceRepo repo;
	private OrderMapper mapper;
	private OutboxRepo outRepo;
	private OrderToOutbox oToOut;

	public OrderService(OrderServiceRepo repo, OrderMapper mapper, OutboxRepo outRepo, OrderToOutbox oToOut) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		this.outRepo = outRepo;
		this.oToOut = oToOut;
	}

	@Transactional
	public Order saveOrder(OrderDTO orderDto) {
			
			Order order = mapper.mapToEntity(orderDto);
			 repo.save(order);
			Outbox map = null;
			
			map = oToOut.map(order);
			outRepo.save(map);
			return order;
			
	}
}
