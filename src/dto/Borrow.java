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
public class Borrow extends Request{

  
    public Borrow() {
    }

    public Borrow(String iD, String assetID, String employeeID, int quantity, Date requestDateTime) {
        super(iD, assetID, employeeID, quantity, requestDateTime);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return this.getiD() + ";" + this.getAssetID() + ";" + this.getEmployeeID() + ";" + this.getQuantity() + ";" + formatter.format(this.getDateTime());
    }
}
