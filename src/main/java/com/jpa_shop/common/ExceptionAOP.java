package com.jpa_shop.common;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

public class ExceptionAOP {

	//JPA 예외를 추상화된 스프링 예외로 변환해주는 AOP
	@Bean
	public PersistenceAnnotationBeanPostProcessor exceptionTranslation() {
		return new PersistenceAnnotationBeanPostProcessor();
	}
}
