/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Admin
 */
public class Asset {

    private String assetID, name, color;
    private int price;
    private float weight;
    private int quantity;

    public Asset() {
    }

    public Asset(String assetID, String name, String color, int price, float weight, int quantity) {
        this.assetID = assetID;
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getAssetID() {
        return assetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return (this.price * (float)this.quantity);
    }

    @Override
    public String toString() {
        return this.assetID + ";" + this.name 
                + ";" + this.color + ";" + this.price + ";" 
                + this.weight + ";" + this.quantity;
    }

    public String show() {
      return "Id:" + this.assetID +  ", name:" + this.name +", color:"+ this.color + ", price:" + this.price+ ", weight:" + this.weight + ", quantity:" +this.quantity + ", total price:" + this.price * this.quantity;
    }

}
