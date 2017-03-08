package com.example.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.model.TollUsage;

@RestController
public class TollServiceClient {

	@Autowired
	DiscoveryClient client;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/client")
	public List<TollUsage> findAll()
	{
		List<ServiceInstance> instances = client.getInstances("tollusagems");
		ServiceInstance serviceInstance = instances.get(0);
		URI uri = serviceInstance.getUri();
		List<TollUsage> tolls = null;
		try {
			tolls = new RestTemplate().getForEntity(new URI(uri.toString().concat("/tolls")), List.class).getBody();
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}
		return tolls;
	}
	
	@RequestMapping(value="/client/{id}")
	public TollUsage find(@PathVariable("id")String id)
	{
		List<ServiceInstance> instances = client.getInstances("tollusagems");
		ServiceInstance serviceInstance = instances.get(0);
		URI uri = serviceInstance.getUri();
		TollUsage toll = null;
		try {
			 toll = new RestTemplate().getForEntity(new URI(uri.toString().concat("/tolls/").concat(id)), TollUsage.class).getBody();
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}
		return toll;
	}
}
