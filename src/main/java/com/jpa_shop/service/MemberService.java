package com.jpa_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa_shop.domain.Member;
import com.jpa_shop.repository.MemberRepository;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	//회원가입
	public Long join(Member member) {
		//아이디를 기준으로 중복체크
		validateDuplicateMember(member);
		//영속화 및 저장
		memberRepository.save(member);
		
		//영속화된 회원의 식별자 추출
		return member.getId();
	}
	
	//중복체크
	public void validateDuplicateMember(Member member) {
		//이름을 받아 중복체크
		List<Member> findMember = memberRepository.findByName(member.getName());
		
		//한명이라도 이름이 겹치는 사람이 존재한다면
		//예외 발생
		if(!findMember.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}
	
	//모든 회원 검색
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	//회원 식별키로 회원 탐색
	public Member findOne(Long memberId) {
		return memberRepository.findById(memberId).get();
	}
}
