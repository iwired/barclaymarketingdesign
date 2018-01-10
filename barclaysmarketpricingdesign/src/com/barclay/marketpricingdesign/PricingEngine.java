package com.barclay.marketpricingdesign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;;

/**
 * Created by freelancer on 3/20/17. If Supply is High and Demand is High,
 * Product is sold at same price as chosen price. If Supply is Low and Demand is
 * Low, Product is sold at 10 % more than chosen price. If Supply is Low and
 * Demand is High, Product is sold at 5 % more than chosen price. If Supply is
 * High and Demand is Low, Product is sold at 5 % less than chosen price.
 * 
 * Prices less than 50% of average price are treated as promotion and not
 * considered. Prices more than 50% of average price are treated as data errors
 * and not considered.
 * 
 * 
 */
public class PricingEngine {

	List<SurveyedData> surveyedDataList;
	
	public void determineNewPrice(List<Product> plist) {

		// If Supply is High and Demand is High, Product is sold at same price
		// as chosen price.
		// If Supply is Low and Demand is Low, Product is sold at 10 % more than
		// chosen price.
		// If Supply is Low and Demand is High, Product is sold at 5 % more than
		// chosen price.
		// If Supply is High and Demand is Low, Product is sold at 5 % less than
		// chosen price.
		//
		// Prices less than 50% of average price are treated as promotion and
		// not considered.
		// Prices more than 50% of average price are treated as data errors and
		// not considered.

		for (Product<?> p : plist) {
		  Set<Entry<String, Float>> es = chosenPriceMap.entrySet();
		  for (Entry<String, Float> et : es) {
			 if (p.getProductCode().equals(et.getKey())) {
				if (p.getProductClassification().getSupply().equals(SupplyDemand.HIGH)
							&& p.getProductClassification().getDemand().equals(SupplyDemand.HIGH)) {
					newPriceMap.put(et.getKey(), et.getValue());
				  } else if (p.getProductClassification().getSupply().equals(SupplyDemand.LOW)
							&& p.getProductClassification().getDemand().equals(SupplyDemand.LOW)) {
					float newPrice = (float) ((float) et.getValue() + (et.getValue() * .10));
					newPriceMap.put(et.getKey(), newPrice);
				  } else if (p.getProductClassification().getSupply().equals(SupplyDemand.LOW)
							&& p.getProductClassification().getDemand().equals(SupplyDemand.HIGH)) {
					float newPrice = et.getValue() +  (float) (.05 * et.getValue());
					 System.out.println("newPrice[" + newPrice + "]");
					newPriceMap.put(et.getKey(), newPrice);
				  } else if (p.getProductClassification().getSupply().equals(SupplyDemand.HIGH)
							&& p.getProductClassification().getDemand().equals(SupplyDemand.LOW)) {
					float newPrice = (float) (et.getValue() - (.05 * et.getValue()));
					newPriceMap.put(et.getKey(), newPrice);
				  }
			 }
		  }
		  Set<Entry<String, Float>> nps = newPriceMap.entrySet();
			for (Entry<String, Float> e : nps) {
				 System.out.println(e.getKey() + " " + e.getValue());
		   }
		}

	}

	public static void printDebugScanParse(String[] parsedInputArray) {
		// for (int i = 0; i < parsedInputArray.length - 1; i++) {
		// System.out.println("parsedInputArray{ [" + parsedInputArray[i] + "]
		// }");
		// }
	}

	public List<SurveyedData> getSurveyedDataList() {
		return surveyedDataList;
	}

	public void setSurveyedDataList(List<SurveyedData> surveyedDataList) {
		this.surveyedDataList = surveyedDataList;
	}

	public Map<String, Float> newPriceMap = new HashMap<String, Float>();

	public Map<String, Float> chosenPriceMap = null;

	public Map<String, Float> getChosenPriceMap() {
		return chosenPriceMap;
	}

	public void setChosenPriceMap(Map<String, Float> chosenPriceMap) {
		this.chosenPriceMap = chosenPriceMap;
	}

	PricingEngine(List<SurveyedData> surveyedDataList) {
		this.surveyedDataList = surveyedDataList;
	}


}
