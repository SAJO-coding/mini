package com.sajo.mini.model.dto;

import java.util.ArrayList;

public class ItemDTO {

    private String itemName;
    private String itemJob;
    private int itemPrice;
    private int itemLevel;
    private int itemJobNumber;

    private String effect;

    public ArrayList<ItemDTO> healerItemDTO = new ArrayList<>();
    public ArrayList<ItemDTO> tankerItemDTO = new ArrayList<>();
    public ArrayList<ItemDTO> dealerItemDTO = new ArrayList<>();


    public ItemDTO() {
    }

    public ItemDTO(String itemName, String itemJob, int itemPrice, int itemLevel, int itemJobNumber, String effect, ArrayList<ItemDTO> healerItemDTO, ArrayList<ItemDTO> tankerItemDTO, ArrayList<ItemDTO> dealerItemDTO) {
        this.itemName = itemName;
        this.itemJob = itemJob;
        this.itemPrice = itemPrice;
        this.itemLevel = itemLevel;
        this.itemJobNumber = itemJobNumber;
        this.effect = effect;
        this.healerItemDTO = healerItemDTO;
        this.tankerItemDTO = tankerItemDTO;
        this.dealerItemDTO = dealerItemDTO;
    }

    public ItemDTO(String name, String job, int i, int i1, String s) {
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

    public int getItemJobNumber() {
        return itemJobNumber;
    }

    public void setItemJobNumber(int itemJobNumber) {
        this.itemJobNumber = itemJobNumber;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public ArrayList<ItemDTO> getHealerItemDTO() {
        return healerItemDTO;
    }

    public void setHealerItemDTO(ArrayList<ItemDTO> healerItemDTO) {
        this.healerItemDTO = healerItemDTO;
    }

    public ArrayList<ItemDTO> getTankerItemDTO() {
        return tankerItemDTO;
    }

    public void setTankerItemDTO(ArrayList<ItemDTO> tankerItemDTO) {
        this.tankerItemDTO = tankerItemDTO;
    }

    public ArrayList<ItemDTO> getDealerItemDTO() {
        return dealerItemDTO;
    }

    public void setDealerItemDTO(ArrayList<ItemDTO> dealerItemDTO) {
        this.dealerItemDTO = dealerItemDTO;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemName='" + itemName + '\'' +
                ", itemJob='" + itemJob + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemLevel=" + itemLevel +
                ", itemJobNumber=" + itemJobNumber +
                ", effect='" + effect + '\'' +
                ", healerItemDTO=" + healerItemDTO +
                ", tankerItemDTO=" + tankerItemDTO +
                ", dealerItemDTO=" + dealerItemDTO +
                '}';
    }
}


