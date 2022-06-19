package com.jpa_shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {
	
	@Id
	//PK
	@GeneratedValue
	//키값 벨류 생성
	@Column(name = "MEMBER_ID")
	//컬럼명과 필드 매핑
	private Long id;
	
	private String name;
	
	//값 타입 지정
	@Embedded
	private Address address;
	
	//관계 지정 외래키 실소유 x
	//일대 다 관계
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<Order>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", address=" + address + ", orders=" + orders + "]";
	}
}
