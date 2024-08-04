package com.Transactional.OutboxPattern.Entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Order_tbl")
public class Order {
		
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private Long orderId;
	private String name;
	private String customerId;
	private String productType;
	private int quantity;
	private BigDecimal price;
	private Date orderDate;
}	
