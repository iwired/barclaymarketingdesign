package com.barclay.marketpricingdesign;

/**
 * Created by freelancer on 3/18/17.
 */
public class ProductClassification {
    private String supply;
    private String demand;

    public ProductClassification() {
    }

    public ProductClassification(String supply, String demand) {
        this.supply = supply;
        this.demand = demand;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }


}
