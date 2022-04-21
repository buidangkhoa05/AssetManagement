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
public class Manager extends Staff{
    private StaffRole role = StaffRole.MA;

    public Manager() {
    }

    public Manager(String employID, String name, String sex, String password, Date birthdate) {
        super(employID, name, sex, password, birthdate);
    }

    public StaffRole getRole() {
        return role;
    }

    public void setRole(StaffRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return this.getEmployID() + ";" + this.getName() + ";" 
                + formatter.format(this.getBirthdate()) + ";" + this.role + ";" 
                + this.getSex() + ";" + this.getPassword();
    }
}
