package com.jpa_shop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//테이블 매핑
@Table(name = "ORDERS")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//지연 로딩 방식 사용
	//다대일 관계 - 관계시 상대가 단건이면 기본값이 즉시로딩 방식
	@JoinColumn(name = "MEMBER_ID")
	//조인의 기준이 되는 컬럼 명시 
	//외래키 실 소유주
	private Member member;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	//일대다 관계 외래키 실소유 x, 모든 경우의 수에 영속성 전이 사용
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//일대일 관계, 모든 경우의 수에 영속성 전이 사용, 지연로딩 방식 사용
	@JoinColumn(name = "DELIVERY_ID")
	//외래키 실소유
	private Delivery delivery;
	
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	//배송 상태를 열거형으로 관리, STRING시 직접 입력 (순차적 x)
	private OrderStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	//연관관계 메서드
	//하나의 주문에 회원을 등록하면
	//주문의 주인이 회원이 되면서
	//회원의 주문 리스트에 해당 주문을 추가함
	//양뱡향 객체탐색 가능
	public void setMember(Member member) {
		this.member = member;
		member.getOrders().add(this);
	}
	
	//주문 상품을 추가하면 해당 주문에 속한 상품을 추가
	//반대로 해당 상품에도 현재 주문을 추가
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	//주문에 배송지를 추가하면
	//배송지에도 주문정보 추가
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
		delivery.setOrder(this);
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
