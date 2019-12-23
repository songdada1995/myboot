package com.spbt.controller.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoBootController {

	@GetMapping("/sayHai")
	public String sayHai() {
		System.out.println("aaa");
		return "你好";
	}
	
	@GetMapping("/showList")
	public Map<String, Object> showList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "jack");
		return map;
	}
}
