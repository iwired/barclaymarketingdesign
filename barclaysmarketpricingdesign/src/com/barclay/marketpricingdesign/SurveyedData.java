package com.barclay.marketpricingdesign;

/**
 * Created by freelancer on 3/18/17.
 */
public class SurveyedData {
	String productCode;
	String competitor;
	float price;


	public SurveyedData() {
	}

	public SurveyedData(String productCode, String competitor, float price) {
		super();
		//System.out.println("[" + productCode + "] [" + competitor + "] [" + String.valueOf(price) + "]");
		this.productCode = productCode;
		this.competitor = competitor;
		this.price = price;
		float total = this.price += price;
        
	}

	public String getCompetitor() {
		return competitor;
	}

	public void setCompetitor(String competitor) {
		this.competitor = competitor;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductCode() {

		return productCode;
	}

	public boolean equals(SurveyedData surveyedData) {
		return productCode.equals(surveyedData.getProductCode()) && price == surveyedData.getPrice();
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	

}
