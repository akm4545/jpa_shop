package com.jpa_shop.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jpa_shop.domain.Member;
import com.jpa_shop.domain.Order;
import com.jpa_shop.domain.OrderSearch;

//@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>{
	//기본 CRUD 외에도 복잡한 검색 기능을 구현하게 도와주는 명세 기능을 사용하기 위해 JpaSpecificationExecutor 추가 상속
	
//	@PersistenceContext
//	//엔티티 매니저 주입
//	EntityManager em;
//	
//	//주문 저장
//	public void save(Order order) {
//		em.persist(order);
//	}
//	
//	//주문 식별자 기준으로 조회
//	public Order findOne(Long id) {
//		return em.find(Order.class, id);
//	}
//	
//	//검색정보만 담고있는 search 오브젝트를 받아 작동
//	public List<Order> findAll(OrderSearch orderSearch){
//		//CriteriaBuilder 얻기
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		//반환타입 
//		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
//		Root<Order> o = cq.from(Order.class);
//		
//		//조건식 설정
//		List<Predicate> criteria = new ArrayList<Predicate>();
//		
//		//검색조건 상태가 존재한다면
//		if(orderSearch.getOrderStatus() != null) {
//			//검색조건과 order의 status가 같은지의 조건을 검색조건 리스트에 저장
//			Predicate status = 
//					cb.equal(o.get("status"), orderSearch.getOrderStatus());
//			criteria.add(status);
//		}
//		
//		//검색어가 존재한다면
//		if(StringUtils.hasText(orderSearch.getMemberName())) {
//			//멤버와 오더를 innerJoin으로 가져옴
//			Join<Order, Member> m = o.join("member", JoinType.INNER);
//			
//			//검색조건 like 추가 회원의 이름에 검색조건의 이름이 포함되어 있는지 확인하는 조건 
//			Predicate name = cb.like(m.<String>get("name"), "%" + orderSearch.getMemberName() + "%");
//			
//			//추가
//			criteria.add(name);	
//		}
//		
//		//추가한 조건식을 and 연산자로 추가함
//		//리스트를 추가한 조건식의 수만큼의 배열로 변환
//		cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
//		
//		//쿼리 실행 최대 1000건 조회
//		TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000);
//		
//		//반환값이 Order로 설정했으므로 orderList가 출력
//		return query.getResultList();
//	}
}
