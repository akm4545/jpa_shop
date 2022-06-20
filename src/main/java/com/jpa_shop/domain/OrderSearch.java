package com.jpa_shop.domain;

import org.springframework.data.jpa.domain.Specification;

import static com.jpa_shop.domain.OrderSpec.memberNameLike;
import static com.jpa_shop.domain.OrderSpec.orderStatusEq;

public class OrderSearch {
	
	private String memberName;
	
	private OrderStatus orderStatus;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	//검색조건이 가지고 있는 정보를 토대로 검색조건을 만들어서 반환 
	public Specification<Order> toSpecification(){
		return Specification.where(memberNameLike(memberName)).and(orderStatusEq(orderStatus));
	}
}
