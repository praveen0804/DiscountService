package com.discount.calculator.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.discount.calculator.Vo.DiscountConfigData;
import com.discount.calculator.util.DiscountCalConstants;


@Configuration
public class DiscountConfig {

	public static final Map<String,List<DiscountConfigData>> DiscountConfigData =  new HashMap<String,List<DiscountConfigData>>();


	//Populating the Map in static Block But we will put this in DB so that restart will not required at any time if we want to add new config.

	@Bean
	protected void populateDiscountData()
	{

		System.out.println("Populating regularUserDataConfig !!!!");


		DiscountConfigData firstSlabDiscountConfigData=getFirstSlabForRegularCustomer();
		DiscountConfigData secondSlabDiscountConfigData=getSecondSlabForRegularCustomer();
		DiscountConfigData thirdSlabDiscountConfigData=getThirdSlabForRegularCustomer();
		List<DiscountConfigData> regularDataList= new ArrayList<DiscountConfigData>();
		regularDataList.add(firstSlabDiscountConfigData);
		regularDataList.add(secondSlabDiscountConfigData);
		regularDataList.add(thirdSlabDiscountConfigData);
		DiscountConfigData.put(DiscountCalConstants.REGULAR_CUSTOMER_TYPE,regularDataList);
		
		
		DiscountConfigData firstSlabDiscountPremiumData=getFirstSlabForPremiumCustomer();
		DiscountConfigData secondSlabDiscountPremiumData=getSecondSlabForPremiumCustomer();
		DiscountConfigData thirdSlabDiscountPremiumData=getThirdSlabForPremiumCustomer();
		DiscountConfigData fourthSlabDiscountPremiumData=getFourthSlabForPremiumCustomer();
		List<DiscountConfigData> premiumDataList= new ArrayList<DiscountConfigData>();
		premiumDataList.add(firstSlabDiscountPremiumData);
		premiumDataList.add(secondSlabDiscountPremiumData);
		premiumDataList.add(thirdSlabDiscountPremiumData);
		premiumDataList.add(fourthSlabDiscountPremiumData);
		DiscountConfigData.put(DiscountCalConstants.PREMIUM_CUSTOMER_TYPE,premiumDataList);


	}


	private com.discount.calculator.Vo.DiscountConfigData getFourthSlabForPremiumCustomer() {
		DiscountConfigData discountConfigData = new DiscountConfigData();
		discountConfigData.setLowerBound(12000d);
		discountConfigData.setUpperBound(0d);
		discountConfigData.setDiscountPercent(30d);
		return discountConfigData;
	}


	private com.discount.calculator.Vo.DiscountConfigData getThirdSlabForPremiumCustomer() {
		DiscountConfigData discountConfigData = new DiscountConfigData();
		discountConfigData.setLowerBound(8000d);
		discountConfigData.setUpperBound(12000d);
		discountConfigData.setDiscountPercent(20d);
		return discountConfigData;
	}


	private com.discount.calculator.Vo.DiscountConfigData getSecondSlabForPremiumCustomer() {
		DiscountConfigData discountConfigData = new DiscountConfigData();
		discountConfigData.setLowerBound(4000d);
		discountConfigData.setUpperBound(8000d);
		discountConfigData.setDiscountPercent(15d);
		return discountConfigData;
	}


	private com.discount.calculator.Vo.DiscountConfigData getFirstSlabForPremiumCustomer() {
		DiscountConfigData discountConfigData = new DiscountConfigData();
		discountConfigData.setLowerBound(0d);
		discountConfigData.setUpperBound(4000d);
		discountConfigData.setDiscountPercent(10d);
		return discountConfigData;
	}


	private DiscountConfigData getFirstSlabForRegularCustomer() {
		DiscountConfigData discountConfigData = new DiscountConfigData();
		discountConfigData.setLowerBound(0d);
		discountConfigData.setUpperBound(5000d);
		discountConfigData.setDiscountPercent(0d);
		return discountConfigData;
	}

	private DiscountConfigData getSecondSlabForRegularCustomer() {
		DiscountConfigData discountConfigData = new DiscountConfigData();
		discountConfigData.setLowerBound(5000d);
		discountConfigData.setUpperBound(10000d);
		discountConfigData.setDiscountPercent(10d);
		return discountConfigData;
	}


	private DiscountConfigData getThirdSlabForRegularCustomer() {
		DiscountConfigData discountConfigData = new DiscountConfigData();
		discountConfigData.setLowerBound(10000d);
		discountConfigData.setUpperBound(0d);
		discountConfigData.setDiscountPercent(20d);
		return discountConfigData;
	}


}
