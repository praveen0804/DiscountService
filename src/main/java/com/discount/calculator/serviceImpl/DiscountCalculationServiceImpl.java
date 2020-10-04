package com.discount.calculator.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.discount.calculator.Vo.CustomerData;
import com.discount.calculator.Vo.DiscountConfigData;
import com.discount.calculator.config.DiscountConfig;
import com.discount.calculator.service.DiscountCalculationService;

@Service
public class DiscountCalculationServiceImpl  implements DiscountCalculationService{
	
	@Autowired
	DiscountConfig discountConfig;

	@Override
	public Double calculateDiscount(CustomerData customerData) {
		
		return processDiscount(customerData.getBillAmount(),customerData.getCustomerType());
		
		
	}

	private Double processDiscount(Double billAmount,String customerType) {
		
		List<DiscountConfigData> regularUserDataConfigList=discountConfig.DiscountConfigData.get(customerType);
		Double discount=0d;
		Double totalAmount=billAmount;
		for(int i=0; (totalAmount>0d && i<regularUserDataConfigList.size());i++)
		{   
			Double upperBound=regularUserDataConfigList.get(i).getUpperBound();
			if(i==regularUserDataConfigList.size()-1)
				upperBound=billAmount;
			discount=discount+(upperBound-regularUserDataConfigList.get(i).getLowerBound())
					*regularUserDataConfigList.get(i).getDiscountPercent()/100;
			if(regularUserDataConfigList.get(i).getLowerBound()>0)
				totalAmount=totalAmount-regularUserDataConfigList.get(i).getLowerBound();
			else
				totalAmount=totalAmount-regularUserDataConfigList.get(i).getUpperBound();	
			
			
		}
		System.out.println("Returning discount:: "+discount);
		return discount;
	}

}
