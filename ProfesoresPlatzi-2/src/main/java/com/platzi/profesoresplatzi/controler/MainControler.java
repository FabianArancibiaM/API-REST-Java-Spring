package com.platzi.profesoresplatzi.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainControler {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String responce = "Bienvenido a <a href='http://Platzi.com'> Platzi.com </a>";
		return responce;
	}
}
