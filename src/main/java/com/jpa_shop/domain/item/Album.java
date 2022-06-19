package com.jpa_shop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
//부모의 테이블이 자식을 식별할 값
public class Album extends Item{
	//상속받아 사용
	
	private String artist;
	
	private String etc;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	@Override
	public String toString() {
		return "Album [artist=" + artist + ", etc=" + etc + "]";
	}
}
