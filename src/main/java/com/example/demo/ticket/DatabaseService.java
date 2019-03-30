package com.example.demo.ticket;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String queryFromDatabase(String ticketSeq) {
	 String sql = "select ticket_stock from tb_ticket where ticket_seq ='"+ ticketSeq +"'";
	
	 Map<String, Object> result = jdbcTemplate.queryForMap(sql);
	
	 return result. get("ticket_stock"). toString();
	}

}
