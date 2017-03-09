package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.TollUsage;
import com.example.repository.TollUsageFeignMSRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TollService implements TollServiceIntf{

	@Autowired
	TollUsageFeignMSRepo repo;
	
	@Override
	@HystrixCommand(fallbackMethod="listOfTollUsageFallback")
	public List<TollUsage> findAll()
	{
		return repo.findAll();
	}
	
	public List<TollUsage> listOfTollUsageFallback()
	{
		List<TollUsage> list = new ArrayList<>();
		list.add(new TollUsage("1", "Wayanad", "KL:12 AA 0000", "01:10"));
		list.add(new TollUsage("2", "Calicut", "KL:12 AA 0000", "01:10"));
		list.add(new TollUsage("3", "Kannur", "KL:12 AA 0000", "01:10"));
		list.add(new TollUsage("4", "Trichur", "KL:12 AA 0000", "01:10"));
		list.add(new TollUsage("5", "Alappi", "KL:12 AA 0000", "01:10"));
		return list;
	}
	
	
	
	@Override
	public TollUsage getById(String id)
	{

		return repo.findById(id);
	}
}
