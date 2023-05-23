package com.weather.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.weather.models.Report;
import com.weather.service.Weatherservice;

@RestController
public class Weathercontroller {

	@Autowired
	Weatherservice service;
	
	@RequestMapping(value="/getweatherreport/{pincode}/{date}", method = RequestMethod.GET)
	
	public List<Report> getDetails(@PathVariable("pincode") int pincode, @PathVariable("date") String date){	
		System.out.println(pincode);
		System.out.println(date);
		List<Report> detailedlist=service.getDetailsDataFromDao();
		return detailedlist;
	}
}
