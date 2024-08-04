package com.Transactional.OutboxPattern.Utils;

import org.springframework.stereotype.Service;

import com.Transactional.OutboxPattern.Entity.Order;
import com.Transactional.OutboxPattern.Entity.Outbox;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@Service
public class OrderToOutbox {
	
	@SneakyThrows
		public Outbox map(Order order)  {
			return Outbox.builder().aggregatedId(order.getOrderId().toString())
					.orderDate(order.getOrderDate())
					.payload(new ObjectMapper().writeValueAsString(order))
					.processed(false)
					.build();
								
		}
}
