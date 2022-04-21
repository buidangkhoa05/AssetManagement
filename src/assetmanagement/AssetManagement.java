/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assetmanagement;

import dto.Asset;
import dto.Borrow;
import dto.Request;
import dto.Staff;
import dto.StaffRole;
import java.text.ParseException;
import java.time.Instant;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import service.AssetService;
import service.BorrowService;
import service.RequestService;
import service.StaffService;
import util.Menu;
import util.Validation;

/**
 *
 * @author Admin
 */
public class AssetManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Controller c = new Controller();
        ArrayList<String> mainMenu = new ArrayList();
        mainMenu.add("Login");
        mainMenu.add("Quit");
        boolean flag = true;
        while (true) {
            switch (Menu.getChoice(mainMenu)) {
                case 1:
                    login(c);
                    break;
                default:
                    flag = false;
                    break;
            }
            if (!flag) {
                break;
            }
        }

    }

    public static void managerMenu(Controller c) {
        System.out.println("");
        ArrayList<String> mainMenu = new ArrayList();
        mainMenu.add("Search asset by name");
        mainMenu.add("Create new asset");
        mainMenu.add("Updating asset's information");
        mainMenu.add("Approve the request of employee");
        mainMenu.add("Show list of borrow asset");
        mainMenu.add("Search asset with weight");
        mainMenu.add("Quit");
        boolean flag = true;
        while (flag) {
            switch (Menu.getChoice(mainMenu)) {
                case 1:
                    c.searchAsset();
                    break;
                case 2:
                    c.createAsset();
                    break;
                case 3:
                    c.updateAsset();
                    break;
                case 4:
                    c.approveRequest();
                    break;
                case 5:
                    c.showBorrowList();
                    break;
                case 6:
                    c.searchAssetWithWeight();
                    break;
                default:
                    flag = false;
                    System.out.println("See you next time :)");
                    break;
            }
        }

    }

    public static void employeeMenu(Controller c) {
        System.out.println("");
        ArrayList<String> mainMenu = new ArrayList();
        mainMenu.add("Search asset by name");
        mainMenu.add("Quit");

        boolean flag = true;
        while (flag) {
            switch (Menu.getChoice(mainMenu)) {
                case 1:
                    c.searchAsset();
                    break;              
                default:
                    flag = false;
                    System.out.println("See you next time :)");
                    break;
            }
        }
    }

    public static void login(Controller c) {
        StaffRole roleLogin = c.login();
        if (roleLogin == null) {
            System.out.println("Login fail!!!");
        } else {
            if (roleLogin.equals(StaffRole.EM)) {
                employeeMenu(c);
            }
            if (roleLogin.equals(StaffRole.MA)) {
                managerMenu(c);
            }
        }
    }
}
