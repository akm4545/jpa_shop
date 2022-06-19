package com.jpa_shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jpa_shop.domain.item.Item;

@Entity
public class Category {
	
	@Id
	//주키
	@GeneratedValue
	//주키 값 생성
	@Column(name = "CATEGORY_ID")
	//컬럼 = 필드
	private Long id;
	
	private String name;
	
	@ManyToMany
	//다대다 관계
	@JoinTable(name = "CATEGORY_ITEM",
		joinColumns = @JoinColumn(name = "CATEGORY_ID"),
		inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
	)
	//조인용 테이블 사용 
	//조인용 테이블에 값이 추가된다면 그냥 엔티티를 생성해서 다대일 관계로 풀어내는게 더 좋음
	//name = 조인용 테이블 이름
	//joinColumns = 조인할 컬럼명
	//inverseJoinColumns = 반대쪽에서 조인할 컬럼 명
	private List<Item> items = new ArrayList<Item>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	//지연 로딩 방식 사용
	@JoinColumn(name = "PARENT_ID")
	//부모 - 자식관계, 현재 자식이 다인 계층형 테이블임, 자식기준으로 자기 자신이 관계의 주인
	private Category parent;
	
	@OneToMany(mappedBy = "parent")
	//부모 - 자식관계, 현재 부모 입장에서는 자식이 여러명임, 관계의 주인이 아님
	private List<Category> child = new ArrayList<Category>();
	
	//연관관계 메서드
	//자식 카테고리를 설정하면 자신에게 자식의 리스트에 추가하면서
	//자식의 부모도 자신으로 설정
	//양뱡향에서 객체탐색이 가능
	public void addChildCategory(Category child) {
		this.child.add(child);
		child.setParent(this);
	}

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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChild() {
		return child;
	}

	public void setChild(List<Category> child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", items=" + items + ", parent=" + parent + ", child=" + child
				+ "]";
	}
}
