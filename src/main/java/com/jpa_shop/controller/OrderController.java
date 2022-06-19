package com.jpa_shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa_shop.domain.Member;
import com.jpa_shop.domain.item.Item;
import com.jpa_shop.service.ItemService;
import com.jpa_shop.service.MemberService;
import com.jpa_shop.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String createForm(Model model) {
		List<Member> members = memberService.findMembers();
		List<Item> items = itemService.findItems();
		
		model.addAttribute("members", members);
		model.addAttribute("items", items);
		
		return "order/orderForm";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(@RequestParam("memberId") Long memberId,
			@RequestParam("itemId") Long itemId,
			@RequestParam("count") int count) {
		orderService.order(memberId, itemId, count);
		
		return "redirect:/orders";
	}
}
