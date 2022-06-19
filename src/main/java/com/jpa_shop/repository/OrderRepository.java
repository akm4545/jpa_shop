package com.jpa_shop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jpa_shop.domain.Order;

@Repository
public class OrderRepository {

	@PersistenceContext
	//엔티티 매니저 주입
	EntityManager em;
	
	//주문 저장
	public void save(Order order) {
		em.persist(order);
	}
	
	//주문 식별자 기준으로 조회
	public Order findOne(Long id) {
		return em.find(Order.class, id);
	}
	
	//아직 미완성
	public List<Order> findAll(OrderSearch orderSearch){
		
	}
}
