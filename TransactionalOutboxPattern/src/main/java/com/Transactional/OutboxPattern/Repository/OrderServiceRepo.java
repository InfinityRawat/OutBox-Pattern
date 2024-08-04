package com.Transactional.OutboxPattern.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Transactional.OutboxPattern.Entity.Order;

public interface OrderServiceRepo extends JpaRepository<Order, Long> {

}
