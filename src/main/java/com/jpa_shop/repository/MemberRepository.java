package com.jpa_shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa_shop.domain.Member;

//@Repository
//JPA 예외를 스프링 추상 예외로 변환
public interface MemberRepository extends JpaRepository<Member, Long>{
	//spring jpa를 사용하기 위해 인터페이스로 선언
	//반복적인 CRUD 작업을 간소화 해줄 JapRepository 상속 제네릭 타입 앞에 사용할 엔티티, 뒤에는 식별자 타입
	//save, findOne, findAll을 기본 제공
	
	//상속받은 데이터 JPA가 메서드 이름을 분석하여 jpql쿼리 실행
	//해당 메서드는 이름을 기준으로 회원을 찾음
	//	"SELECT"
	//	+ "m"
	//	+ "FROM"
	//	+ "Member m"
	//	+ "WHERE"
	//	+ "m.name = :name", Member.class)
	//	.setParameter("name", name)
	//	.getResultList();
	List<Member> findByName(String name);

//	@PersistenceContext
//	//엔티티 매니저 주입
//	EntityManager em;
//	
//	//엔티티 저장 (영속화)
//	public void save(Member member) {
//		em.persist(member);
//	}
//	
//	//식별자를 기준으로 조회
//	public Member findOne(Long id) {
//		return em.find(Member.class, id);
//	}
//	
//	//회원 전체 조회
//	public List<Member> findAll() {
//		return em.createQuery(""
//				+ "SELECT"
//				+ "m"
//				+ "FROM"
//				+ "Member m", Member.class)
//				.getResultList();
//	}
//	
//	//이름 파라미터를 받아 해당하는 이름을 가진 회원 조회
//	public List<Member> findByName(String name){
//		return em.createQuery("SELECT"
//				+ "m"
//				+ "FROM"
//				+ "Member m"
//				+ "WHERE"
//				+ "m.name = :name", Member.class)
//				.setParameter("name", name)
//				.getResultList();
//	}
}
