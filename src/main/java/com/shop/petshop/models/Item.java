package com.shop.petshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", unitPrice=" + unitPrice +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private String productName;
    private Integer amount;

    public Item() {
    }

    public Item(String productName,Double unitPrice,Integer amount) {
        this.productName = productName;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    private Double unitPrice;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
