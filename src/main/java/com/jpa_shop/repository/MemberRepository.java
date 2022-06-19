package com.jpa_shop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jpa_shop.domain.Member;

@Repository
//JPA 예외를 스프링 추상 예외로 변환
public class MemberRepository {
	
	@PersistenceContext
	//엔티티 매니저 주입
	EntityManager em;
	
	//엔티티 저장 (영속화)
	public void save(Member member) {
		em.persist(member);
	}
	
	//식별자를 기준으로 조회
	public Member findOne(Long id) {
		return em.find(Member.class, id);
	}
	
	//회원 전체 조회
	public List<Member> findAll() {
		return em.createQuery(""
				+ "SELECT"
				+ "m"
				+ "FROM"
				+ "Member m", Member.class)
				.getResultList();
	}
	
	//이름 파라미터를 받아 해당하는 이름을 가진 회원 조회
	public List<Member> findByName(String name){
		return em.createQuery("SELECT"
				+ "m"
				+ "FROM"
				+ "Member m"
				+ "WHERE"
				+ "m.name = :name", Member.class)
				.setParameter("name", name)
				.getResultList();
	}
}
