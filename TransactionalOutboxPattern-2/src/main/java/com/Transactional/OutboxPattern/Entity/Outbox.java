package com.Transactional.OutboxPattern.Entity;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="outbox_tbl")
@Builder
public class Outbox {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String aggregatedId;
	private String payload;
	private Date orderDate;
	private Boolean processed;
}
