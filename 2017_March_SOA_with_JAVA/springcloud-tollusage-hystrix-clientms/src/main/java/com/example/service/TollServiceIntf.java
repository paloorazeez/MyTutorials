package com.example.service;

import java.util.List;

import com.example.model.TollUsage;

public interface TollServiceIntf {

	List<TollUsage> findAll();
	TollUsage getById(String id);
}
