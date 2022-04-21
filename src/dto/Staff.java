/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public abstract class Staff {
    private String employID, name, sex, password;
    private Date birthdate;

    public Staff() {
    }
    
    public Staff(String employID, String name, String sex, String password, Date birthdate) {
        this.employID = employID;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.birthdate = birthdate;
    }

    public String getEmployID() {
        return employID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }    

    @Override
    public abstract  String toString();
    
    
}
