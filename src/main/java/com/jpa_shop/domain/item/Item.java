package com.jpa_shop.domain.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import com.jpa_shop.domain.Category;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//부모 테이블 전략 - 한 테이블에 모든 정보 몰아넣기
@DiscriminatorColumn(name = "DTYPE")
//테이블의 정보를 구별하는 컬럼 설정
public abstract class Item {
	//직접 사용하는 엔티티가 아니라 추상 클래스 선언
	//상속받아 사용할것
	
	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;
	
	private String name;
	
	private int price;
	
	private int stockQuantity;
	
	@ManyToMany(mappedBy = "items")
	//다대다 관계 
	//하나의 아이템이 다중 카테고리에 속할 수 있고
	//하나의 카테고리에 여러개의 아이템이 속할 수 있음 
	private List<Category> categories = new ArrayList<Category>();

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", stockQuantity=" + stockQuantity
				+ ", categories=" + categories + "]";
	}
}
