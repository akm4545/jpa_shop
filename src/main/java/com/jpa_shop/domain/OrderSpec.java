package com.jpa_shop.domain;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class OrderSpec {
	//명세를 제공하기 위해 작성한 클래스
	
	//명세를 반환
	public static Specification<Order> memberNameLike(final String memberName){
		
		//새로운 명세를 반환 - 무명 클래스
		//toPredicate를 구현해서 반환해야함 
		return new Specification<Order>() {
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder bulider) {
				if(StringUtils.isEmpty(memberName)) {
					return null;
				}
				
				//쿼리 시작점인 root의 order엔티티의 정보를 토대로 
				//member와 InnerJoin 후 결과를 저장
				Join<Order, Member> m =
						root.join("member", JoinType.INNER);
				
				//where절 like, 매개변수로 받은 memberName 조인 결과의 member.name 컬럼에 포함된 것이 있는지 조회
				return bulider.like(m.<String>get("name"), "%" + memberName + "%");
			}
		};
	}
	
	public static Specification<Order> orderStatusEq(final OrderStatus orderStatus){
		return new Specification<Order>() {
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder bulider) {
				if(orderStatus == null) {
					return null;
				}
				
				//order의 status가 매개변수로 받은 status랑 일치하는지 
				return bulider.equal(root.get("status"), orderStatus);
			}
		};
	}
}
