package com.Transactional.OutboxPattern.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Transactional.OutboxPattern.DTO.OrderDTO;
import com.Transactional.OutboxPattern.Entity.Order;
import com.Transactional.OutboxPattern.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderServiceController {

		private OrderService service;

		public OrderServiceController(OrderService service) {
			super();
			this.service = service;
		}
		
		
		@PostMapping("/save")
		public ResponseEntity<Order> saveOrder(@RequestBody OrderDTO order) {
				
			Order saveOrder = service.saveOrder(order);	
			return  ResponseEntity.status(HttpStatus.ACCEPTED).body(saveOrder);
		}
}
