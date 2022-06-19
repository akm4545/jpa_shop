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
	private Item item;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//다대일 관계, 지연로딩 사용
	@JoinColumn(name = "ORDER_ID")
	//외래키 실소유
	private Order order;
	
	private int orderPrice;
	
	private int count;
	
	//생성 메서드
	public static OrderItem createOrderItem(Item item, int orderPrice,
			int count) {
		//주문 상품의 정보를 담을 엔티티 생성
		OrderItem orderItem = new OrderItem();
		
		//상품의 정보를 담음
		orderItem.setItem(item);
		//상품의 가격을 담음
		orderItem.setOrderPrice(orderPrice);
		//상품의 주문 수량을 담음
		orderItem.setCount(count);
		
		//상품의 재고량 차감
		item.removeStock(count);
		
		return orderItem;
	}
	
	//비즈니스 로직
	public void cancel() {
		//주문하려던 상품의 정보를 가져와 재고를 복구시킨다
		getItem().addStock(count);
	}

	//수량을 곱한 총 가격을 가져옴
	public int getTotalPrice() {
		return getOrderPrice() * getCount();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
		return "OrderItem [id=" + id + ", item=" + item + ", order=" + order + ", orderPrice=" + orderPrice + ", count="
				+ count + "]";
	}
}
