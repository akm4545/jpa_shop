package com.jpa_shop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
//부모 테이블이 자식을 식별할 값
public class Movie extends Item{
	//상속받아 사용
	
	private String director;
	
	private String actor;

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	@Override
	public String toString() {
		return "Movie [director=" + director + ", actor=" + actor + "]";
	}
}
