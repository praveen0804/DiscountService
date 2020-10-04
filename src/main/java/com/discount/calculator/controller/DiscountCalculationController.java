package com.discount.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.discount.calculator.Vo.CustomerData;
import com.discount.calculator.service.DiscountCalculationService;

@RestController
public class DiscountCalculationController {

	@Autowired
	private DiscountCalculationService discountCalculationService;



	@RequestMapping(value="/getBillAmount",method = RequestMethod.POST)
	public Double getBillAmount( @RequestBody CustomerData customerData)
	{

		return customerData.getBillAmount()-discountCalculationService.calculateDiscount(customerData);

	}

}
