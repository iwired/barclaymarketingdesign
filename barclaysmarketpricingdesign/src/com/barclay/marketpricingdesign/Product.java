package com.barclay.marketpricingdesign;

/**
 * Created by freelancer on 3/18/17.
 */
public class Product<ProductName>{

    private ProductClassification productClassification;

    private String productCode;


    public Product(String productName) {
        productCode = productName;
        
    }


    public ProductClassification getProductClassification() {
        return productClassification;
    }

    public void setProductClassification(ProductClassification productClassification) {
        this.productClassification = productClassification;
    }


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }


}
