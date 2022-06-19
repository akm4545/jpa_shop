package com.jpa_shop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
//공통 요소를 상속받은 부모에게서 자식을 구별할 컬럼의 값
public class Book extends Item{
	//상속받아 사용
	
	private String author;
	
	private String isbn;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", isbn=" + isbn + "]";
	}
}
