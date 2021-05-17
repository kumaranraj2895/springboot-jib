package com.springboot.myproject;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController 
{
	@LocalServerPort
	private static int port;
	
	@Autowired
	private IProductService productService;
	
	
	@RequestMapping("/")
	public String getMessage() throws UnknownHostException{
		String ip = InetAddress.getLocalHost().getHostAddress();
		System.out.println("Application is listening in" + ip);
		return "You're not Welcome to Products Catalog" + "\n" + "\n App is listening on:" + ip;

	}
	
	@GetMapping(value = "/products")
	public List<Product> getProduct()  {
		List<Product> products = productService.findAll();
		//returns the product list
		return products;
	}
		
}
