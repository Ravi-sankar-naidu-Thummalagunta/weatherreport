package com.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.dao.Weatherdao;
import com.weather.models.Report;

@Service
public class Weatherservice {

	@Autowired
	Weatherdao dao;
	
	public List<Report> getDetailsDataFromDao() {
	
		return dao.getdetailsfromdb();
	}

}
