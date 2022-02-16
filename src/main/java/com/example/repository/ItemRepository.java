package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;

@Repository
public class ItemRepository {
	
	@Autowired
    private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Item> ITEM_ROW_MAPPER = new BeanPropertyRowMapper<>(Item.class);
	
	public List<Item> findAll() {
		String findAllSql = "SELECT * FROM items ORDER BY id ASC;";
		List<Item> itemList = template.query(findAllSql, ITEM_ROW_MAPPER);
		return itemList;
	}
}
