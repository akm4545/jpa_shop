package com.jpa_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa_shop.domain.Delivery;
import com.jpa_shop.domain.Member;
import com.jpa_shop.domain.Order;
import com.jpa_shop.domain.OrderItem;
import com.jpa_shop.domain.OrderSearch;
import com.jpa_shop.domain.item.Item;
import com.jpa_shop.repository.MemberRepository;
import com.jpa_shop.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemService itemService;
	
	//엔티티가 비즈니스 로직을 가지고 있음 - 도메인 모델 패턴
	//서비스 계층에서 비즈니스 로직을 처리함 - 트랜잭션 스크립트 패턴
	
	//주문정보 저장
	public Long order(Long memberId, Long itemId, int count) {
		//멤버정보 가져옴
		Member member = memberRepository.findById(memberId).get();
		//상품 정보 가져옴
		Item item = itemService.findOne(itemId);
		
		//회원의 배송지 정보를 가져옴 - 영속화 x
		Delivery delivery = new Delivery(member.getAddress());
		
		//가져온 정보를 토대로 주문상품 정보를 만듦 - 영속화 x
		OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
		
		//만든 정보를 토대로 주문 정보를 만듦 - 영속화 x
		Order order = Order.createOrder(member, delivery, orderItem);
		
		//영속화와 동시에 DB 저장
		orderRepository.save(order);
		return order.getId();
	}
	
	public void cancelOrder(Long orderId) {
		//주문 정보를 가져옴
		Order order = orderRepository.findById(orderId).get();
		
		//상태 변경 - 영속화 및 DB 저장
		order.cancel();
	}
	
	//검색조건을 담고있는 객체로 검색 실행
	public List<Order> findOrders(OrderSearch orderSearch){
		//검색조건 반환 메서드를 실행해서 넘기도록 변경
		return orderRepository.findAll(orderSearch.toSpecification());
	}
}
