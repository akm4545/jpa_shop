package com.jpa_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa_shop.domain.item.Item;

//@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	//기본 CRUD만 사용하므로 코드가 필요없음
	//기존의 역할은 스프링 데이터 JPA가 처리
	
//	@PersistenceContext
//	//엔티티 매니저 주입
//	EntityManager em;
//	
//	//아이템 저장
//	public void save(Item item) {
//		//아이템의 식별자가 없으면
//		//즉 새로 저장하는 데이터
//		if(item.getId() == null) {
//			//DB 저장 및 영속화
//			em.persist(item);
//		} else {
//			//식별자가 존재하면 
//			//즉 이미 영속화 되었던 데이터
//			//병합 = 수정
//			em.merge(item);
//		}
//	}
//	
//	//식별자 기준으로 아이템 찾기
//	public Item findOne(Long id) {
//		return em.find(Item.class, id);
//	}
//	
//	//모든 아이템 불러오기
//	public List<Item> findAll() {
//		return em.createQuery("SELECT "
//				+ "i " //별칭으로 조회 - 조건이 없으므로 모두 조회
//				+ "FROM "
//				+ "Item i", Item.class) //Item 클래스의 별칭 i 
//				.getResultList();
//	}
}
