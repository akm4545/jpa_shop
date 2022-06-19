package com.jpa_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpa_shop.domain.item.Book;
import com.jpa_shop.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/items/new", method = RequestMethod.GET)
	public String createForm() {
		return "items/createItemForm";
	}
	
	@RequestMapping(value = "/items/new", method = RequestMethod.POST)
	public String create(Book item) {
		itemService.saveItem(item);
		
		return "redirect:/items";
	}
}
