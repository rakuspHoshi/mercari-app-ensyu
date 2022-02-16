package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemConroller {
	
	public static final int ROW_PAR_PAGE = 30;

    @Autowired
    private HttpSession session;

    @Autowired
    private ItemService itemService;
    
    @RequestMapping("")
    public String index(Model model) {
    	List<Item> itemList = itemService.showList();
    	model.addAttribute("itemList", itemList);
    	return "test";
    }
}
