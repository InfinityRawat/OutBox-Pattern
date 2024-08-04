package com.Transactional.OutboxPattern.Utils;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.Transactional.OutboxPattern.DTO.OrderDTO;
import com.Transactional.OutboxPattern.Entity.Order;

@Service
public class OrderMapper {
		
	public OrderDTO mapToDTO(Order order) {
		return OrderDTO.builder()
				.name(order.getName())
				.customerId(order.getCustomerId())
				.price(order.getPrice())
				.productType(order.getProductType())
				.quantity(order.getQuantity())
				.build();
	}
	
	public Order mapToEntity(OrderDTO order) {
		return Order.builder()
				.name(order.getName())
				.customerId(order.getCustomerId())
				.price(order.getPrice())
				.productType(order.getProductType())
				.quantity(order.getQuantity())
				.orderDate(new Date())
				.build();
	}
}
