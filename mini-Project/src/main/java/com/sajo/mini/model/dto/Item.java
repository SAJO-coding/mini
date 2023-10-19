package com.sajo.mini.model.dto;

public class Item {

    private String itemName;
    private String itemJob;
    private int itemPrice;
    private int itemLevel;

    private String effect;

    public Item() {
    }

    public Item(String itemName, String itemJob, int itemPrice, int itemLevel, String effect) {
        this.itemName = itemName;
        this.itemJob = itemJob;
        this.itemPrice = itemPrice;
        this.itemLevel = itemLevel;
        this.effect = effect;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemJob() {
        return itemJob;
    }

    public void setItemJob(String itemJob) {
        this.itemJob = itemJob;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemJob='" + itemJob + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemLevel=" + itemLevel +
                ", effect='" + effect + '\'' +
                '}';
    }
}


