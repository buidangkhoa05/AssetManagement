/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Request {

    private String iD, assetID, employeeID;
    int quantity;
    Date dateTime;

    public Request() {
    }

    public Request(String iD, String assetID, String employeeID, int quantity, Date requestDateTime) {
        this.iD = iD;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.dateTime = requestDateTime;
    }

    public String getiD() {
        return iD;
    }

    public void setrID(String iD) {
        this.iD = iD;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date requestDateTime) {
        this.dateTime = requestDateTime;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return iD + ";" + assetID + ";" + employeeID + ";" + quantity + ";" + formatter.format(dateTime);
    }

    public String show() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return "rId=" + iD + ", AssetId:" + assetID + ", EmployeeId:" + employeeID + ", quantity:" + quantity + ", Date time:" + formatter.format(dateTime);
    }
}
