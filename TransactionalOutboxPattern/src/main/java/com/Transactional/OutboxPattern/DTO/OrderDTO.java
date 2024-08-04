package com.Transactional.OutboxPattern.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

	private String name;
	private String customerId;
	private String productType;
	private int quantity;
	private BigDecimal price;
}
