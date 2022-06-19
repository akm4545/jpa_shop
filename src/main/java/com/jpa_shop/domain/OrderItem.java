package com.jpa_shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jpa_shop.domain.item.Item;

@Entity
@Table(name = "ORDER_ITEM")
//테이블 매핑
public class OrderItem {

	@Id
	//PK
	@GeneratedValue
	//벨류 자동 생성
	@Column(name = "ITEM_ID")
	//컬럼 매핑
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//다대일 관계, 지연로딩 사용
	@JoinColumn(name = "ITEM_ID")
	//외래키의 실 소유
	private Item itme;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//다대일 관계, 지연로딩 사용
	@JoinColumn(name = "ORDER_ID")
	//외래키 실소유
	private Order order;
	
	private int orderPrice;
	
	private int count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItme() {
		return itme;
	}

	public void setItme(Item itme) {
		this.itme = itme;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", itme=" + itme + ", order=" + order + ", orderPrice=" + orderPrice + ", count="
				+ count + "]";
	}
}
