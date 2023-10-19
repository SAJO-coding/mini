package com.sajo.mini.model.dto;

public class ProductDTO {
    String ProductName;
    String Job;
    int price;
    int levelRestriction;
    String demonstration;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLevelRestriction() {
        return levelRestriction;
    }

    public void setLevelRestriction(int levelRestriction) {
        this.levelRestriction = levelRestriction;
    }

    public String getDemonstration() {
        return demonstration;
    }

    public void setDemonstration(String demonstration) {
        this.demonstration = demonstration;
    }

    public ProductDTO(String productName, String job, int price, int levelRestriction, String demonstration) {
        ProductName = productName;
        Job = job;
        this.price = price;
        this.levelRestriction = levelRestriction;
        this.demonstration = demonstration;
    }

    public ProductDTO() {
    }
}
