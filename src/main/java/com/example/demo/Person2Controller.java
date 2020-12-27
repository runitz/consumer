package com.example.demo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Person;
import com.example.demo.domain.Wrapper;
@RestController
public class Person2Controller {
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
//	@Bean
//	@GetMapping("/persons")
//	public Object getPerson(RestTemplate rest) {
//		Person[] ps = rest.getForObject("http://127.0.0.1:8081/persons", Person[].class);
//		return new Wrapper(ps);
//	}
	
	@Autowired
	DiscoveryClient discover;
	
	@Bean
	@GetMapping("/persons")
	public Object getPerson(RestTemplate rest) {
		List<ServiceInstance> instance = discover.getInstances("provider");
		ServiceInstance service = instance.get(0);
		URI uri = service.getUri();
		Person[] ps = rest.getForObject(uri+"/persons", Person[].class);
		return new Wrapper(ps);
	}
	
}
