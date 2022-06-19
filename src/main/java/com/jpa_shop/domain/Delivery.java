package com.jpa_shop.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery {
	
	@Id
	//PK
	@GeneratedValue
	//키값 생성
	@Column(name = "DELIVERY_ID")
	//컬럼 = 필드
	private Long id;
	
	@OneToOne(mappedBy = "delivery")
	//일대일 관계 
	//외래키 실소유 x
	private Order order;
	
	@Embedded
	//값 타입 사용
	private Address address;
	
	@Enumerated(EnumType.STRING)
	//열거형으로 배송상태 표시 - 직접 입력 방식
	private DeliveryStatus statsus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DeliveryStatus getStatsus() {
		return statsus;
	}

	public void setStatsus(DeliveryStatus statsus) {
		this.statsus = statsus;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", order=" + order + ", address=" + address + ", statsus=" + statsus + "]";
	}
}
