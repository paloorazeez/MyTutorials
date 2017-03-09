package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.TollUsage;
import com.example.repository.TollRepository;

@RestController
public class TollService {

	@Autowired
	private TollRepository tollRepository;
	
	@RequestMapping(value="/tolls",method=RequestMethod.GET)
	public List<TollUsage> findAll(){
		/*List<TollUsage> list = new ArrayList<>();
		list.add(new TollUsage("1", "Wayanad", "KL:12 AA 0000", "01:10"));
		list.add(new TollUsage("2", "Calicut", "KL:12 AA 0000", "01:10"));
		list.add(new TollUsage("3", "Kannur", "KL:12 AA 0000", "01:10"));
		list.add(new TollUsage("4", "Trichur", "KL:12 AA 0000", "01:10"));
		list.add(new TollUsage("5", "Alappi", "KL:12 AA 0000", "01:10"));
		return list;*/
		return tollRepository.findAll();
	}
	
	@RequestMapping(value="/tolls/{id}", method=RequestMethod.GET)
	public TollUsage findById(@PathVariable("id")String id)
	{
		return tollRepository.findOne(id);
	}
	
	
	@RequestMapping(value="/tolls", method=RequestMethod.POST)
	public ResponseEntity<TollUsage> save(@RequestBody TollUsage toll)
	{
		tollRepository.save(toll);
		return new ResponseEntity<>(toll, HttpStatus.CREATED);
	}
		
}
