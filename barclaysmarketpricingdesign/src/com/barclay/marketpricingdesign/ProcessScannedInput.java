package com.barclay.marketpricingdesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by freelancer on 3/19/17. implements Consumer < String > 2 flashdrive
 * H H ssd L H 5 flashdrive X 1.0s ssd X 10.0 flashdrive Y 0.9 flashdrive Z 1.1
 * ssd Y 12.5
 */
public class ProcessScannedInput {
	float average = 0f;
	private static final int LENGTH = 1;
	Product p = null;
	private List<Product> productList = null;
	private List<SurveyedData> surveyedDataList = null;
	private PricingEngine pricingEngine = null;
	Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
	Map<String, Float> frequencyPrice = new HashMap<String, Float>();
	public Map<String, Float> chosenPriceMap = new HashMap<String, Float>();

	ProcessScannedInput() {
		surveyedDataList = new ArrayList<SurveyedData>();
		productList = new ArrayList<Product>();
	}

	public void delegateProductDetails(List<String> pd) {
		for (String s : pd) {
			String[] parsedInputArray = parseConsumedInput(s);
			p = new Product<String>(parsedInputArray[0]);
			 printDebugScanParse(parsedInputArray);
			System.out.println("name " + p.getProductCode());
			ProductClassification pc = new ProductClassification
					(parsedInputArray[1], 
					parsedInputArray[2]);
			p.setProductClassification(pc);
			 System.out.println("demand " + pc.getDemand());
			 System.out.println("supply " + pc.getSupply());
			productList.add(p);
			 System.out.println("productList" + productList.size());
		}
	}

	public void delegateMarketingData(List<String> md) {
		for (String s : md) {
			String[] parsedInputArray = parseConsumedInput(s);
			SurveyedData surveyedData = new SurveyedData
					(parsedInputArray[0], 
					 parsedInputArray[1],
					 Float.valueOf(parsedInputArray[2]));
			surveyedDataList.add(surveyedData);
		}
		frequencyMap = findFrequency(surveyedDataList);
		for (Entry<String, Integer> entries: frequencyMap.entrySet())
		{
		   System.out.println("[" + entries.getKey() + "] ["
		           + entries.getValue() + "]");
		}
		for (Entry<String, Float> es : chosenPriceMap.entrySet()) {
			System.out.println("[chosenPriceMap:" + es.getKey() +
					"] [" + es.getValue() + "]");
		}
		PricingEngine pEngine = new PricingEngine(surveyedDataList);
		pEngine.setChosenPriceMap(this.chosenPriceMap);
		pEngine.determineNewPrice(productList);
	}

	public void accept(int il1, int il2, List<String> sl3) {
		List<String> pd = new ArrayList<String>();
		List<String> md = new ArrayList<String>();
		System.out.println("numProducts[" + il1 + "]");
		System.out.println("numSurveys[" + il2 + "]");
		productList = new ArrayList<Product>();
		int index_i = 0;
		int index_j = 0;
		for (index_i = 0; index_i < il1; index_i++) {
			pd.add(sl3.get(index_i));
		}
		System.out.println("pd size[" + pd.size() + "]");
		for (index_j = index_i; index_j < sl3.size()-1; index_j++) {
			md.add(sl3.get(index_j));
		}
		System.out.println("md size[" + md.size() + "]");
		delegateProductDetails(pd);
		delegateMarketingData(md);

	}

	
	public String[] parseConsumedInput(String arrayItem) {
		String[] newArray = arrayItem.split("\\s");
		return newArray;
	}

	 /* trace debug */
	 public static void printDebugScanParse(String[] parsedInputArray) {
	 for (int i = 0; i < parsedInputArray.length - 1; i++) {
	 System.out.println("parsedInputArray{ [" + parsedInputArray[i] + "] }");
	 }
	 }
	
	 public static void printDebugList(List<SurveyedData> surveyDataList) {
	
	 for (SurveyedData sd : surveyDataList) {
	 System.out.println("surveydata[" + surveyDataList.size() + "]" +
	 sd.getProductCode() + sd.getCompetitor()
	 + sd.getPrice());
	 }
	 }
	
	 public void printChosenPrice() {
	 Set<Entry<String, Float>> entrySet = getChosenPriceMap().entrySet();
	 for (Entry<String, Float> entry : entrySet) {
	 System.out.println(entry.getKey() + " " + entry.getValue());
	 }
	 }

	public Map<String, Integer> findFrequency(List<SurveyedData> surveyedDataList) {
		int frequency = 1;
		for (SurveyedData s : surveyedDataList) {
			System.out.println("productCode[" + s.productCode + "]");
			if (frequencyMap.containsKey(s.productCode)) {	
				System.out.println("map has it productCode[" + s.productCode + "]");
				frequencyMap.replace(s.productCode, frequency);
				// if frequency greater than 1 chosenPriceMap price
				// should be replaced by the lower price of
				if (chosenPriceMap.get(s.productCode) != null && 
					chosenPriceMap.get(s.productCode) > s.getPrice()) {
					chosenPriceMap.replace(s.productCode, s.getPrice());
				}
               frequency+=1;  
			} else {	
				System.out.println("map doesnt productCode[" + s.productCode + "]");
				frequencyMap.put(s.productCode, 1);
				chosenPriceMap.put(s.productCode, s.getPrice());
			}
		}
		for (Entry<String, Integer> entries: frequencyMap.entrySet())
		{
		   System.out.println("[" + entries.getKey() + "] ["
		           + entries.getValue() + "]");
		}
		return frequencyMap;
	}

	public Map<String, Float> getChosenPriceMap() {
		return chosenPriceMap;
	}

	public void setChosenPriceMap(Map<String, Float> chosenPriceMap) {
		this.chosenPriceMap = chosenPriceMap;
	}

}
