package com.zipcode.zipcodesformatter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zipcode.zipcodesformatter.service.ZipCodeSFormatterServiceImpl;

@RestController
public class ZipCodeRangesController {
	
	@Autowired
	private ZipCodeSFormatterServiceImpl service;
	
	// This end point will take hard coded value in getZipCodeRangesData method
	@GetMapping("/zipcodes")
	public String getZipCodeRanges() {
		return service.formatZipCodeRanges(getZipCodeRangesData());
	}
	
	// This end point to submit the input from postmain or soap ui tool
	@PostMapping("/zipcodes1")
	public String getZipCodesRanges(@RequestBody String zipCodes) {
		return service.formatZipCodeRanges(zipCodes);
	}
	
	@GetMapping("/hello")
	public String getMessage() {
		// Just to verify whether app is running or not.
		return "Hello";
	}
	
	private String getZipCodeRangesData() {
		// Change the data here to run the end point.
		return "[94133,94133] [94200,94299] [94226,94399]";
	}
}
