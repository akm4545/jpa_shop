package com.jpa_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa_shop.domain.item.Item;
import com.jpa_shop.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	//저장 혹은 수정
	public void saveItem(Item item) {
		itemRepository.save(item);
	}
	
	//모든 정보 불러오기
	public List<Item> findItems(){
		return itemRepository.findAll();
	}
	
	//식별자 기준으로 조회
	public Item findOne(Long itemId) {
		return itemRepository.findOne(itemId);
	}
}
