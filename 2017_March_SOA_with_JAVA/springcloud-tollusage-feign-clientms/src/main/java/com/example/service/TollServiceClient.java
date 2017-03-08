package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.TollUsage;
import com.example.repository.TollUsageFeignMSRepo;

@RestController
public class TollServiceClient {

	@Autowired
	TollUsageFeignMSRepo repo;
	
	@RequestMapping(value="/client")
	public List<TollUsage> findAll()
	{
		return repo.findAll();
	}
	
	@RequestMapping(value="/client/{id}")
	public TollUsage find(@PathVariable("id")String id)
	{

		return repo.findById(id);
	}
}
