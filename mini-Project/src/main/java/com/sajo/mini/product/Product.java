package com.sajo.mini.product;

public class Product {
    private String productName;
    private String job;
    private int price;
    private int levelRestriction;
    private String demonstration;

    public Product() {
    }

    public Product(String productName, String job, int price, int levelRestriction, String demonstration) {
        this.productName = productName;
        this.job = job;
        this.price = price;
        this.levelRestriction = levelRestriction;
        this.demonstration = demonstration;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", job='" + job + '\'' +
                ", price=" + price +
                ", levelRestriction=" + levelRestriction +
                ", demonstration='" + demonstration + '\'' +
                '}';
    }
}
