/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assetmanagement;

import dto.Asset;
import dto.Borrow;
import dto.Employee;
import dto.Manager;
import dto.Request;
import dto.Staff;
import dto.StaffRole;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import service.AssetService;
import service.BorrowService;
import service.RequestService;
import service.StaffService;
import util.Validation;

/**
 *
 * @author Admin
 */
public class Controller {

    String assetPath = "asset.txt";
    String staffPath = "staff.txt";
    String requestPath = "request.txt";
    String borrowPath = "borrow.txt";

    List<Asset> assetlist = new ArrayList<Asset>();
    AssetService as = new AssetService(assetPath, assetlist);

    List<Staff> staffList = new ArrayList<Staff>();
    StaffService ss = new StaffService(staffPath, staffList);

    List<Request> requestList = new ArrayList<Request>();
    RequestService rs = new RequestService(requestPath, requestList);

    List<Borrow> borrowList = new ArrayList<Borrow>();
    BorrowService bs = new BorrowService(borrowPath, borrowList);

    public StaffRole login() {
        ss.loadFile();
        String iD = Validation.inputString("Input id: ");
        String password = Validation.inputString("Input password: ");
        boolean statusLogin = false;
        StaffRole role = null;
        for (Staff s : ss.getAll()) {
            if (s.getEmployID().equals(iD) && s.getPassword().equals(password)) {
                statusLogin = true;
                if (s instanceof Manager) {
                    role = StaffRole.MA;
                } else if (s instanceof Employee) {
                    role = StaffRole.EM;
                }
                break;
            }
        }
        if (statusLogin) {
            System.out.println("-Login successfully-");
        } else {
            System.out.println("Incorrect id or password !!!");
        }
        return role;
    }

    public void searchAsset() {
        as.loadFile();
        String assetName = Validation.inputString("Input asset name: ");
        List<Asset> result = new ArrayList<>();
        for (int i = 0; i < assetlist.size(); i++) {
            Asset a = assetlist.get(i);
            if (a.getName().contains(assetName)) {
                result.add(a);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Can found");
            System.out.println("");
        } else {
            Collections.sort(result, (c1, c2) -> {
                int comp = c1.getAssetID().compareTo(c2.getAssetID());
                if (comp <= -1) {
                    return 1;
                } else if (comp == 0) {
                    return 0;
                }
                return -1;
            });
            System.out.println("---Asset List---");
            for (Asset a : result) {
                System.out.println(a.show());
            }
            System.out.println("");
        }
    }

    public void createAsset() {
        as.loadFile();
        String assetID = isAssetIdDuplicate(Validation.inputString("Input asset id:"));
        String name = Validation.inputString("Input asset name: ");
        String color = Validation.inputString("Input asset color: ");
        int price = Validation.inputInt("Input asset price: ");
        float weight = Validation.inputFloat("Input asset weight: ");
        int quantity = Validation.inputInt("Input asset quantity: ");
        as.add(new Asset(assetID, name, color, price, weight, quantity));
        as.saveFile();
        System.out.println("Create new asset successfully");
        if (Validation.inputYesNo("Do you want continute create asset(Y/N)")) {
            createAsset();
        }
    }

    void updateAsset() {
        as.loadFile();
        System.out.println("----Update----");
        String uId = Validation.inputString("Input id: ");
        Asset uAsset = as.get(a -> a.getAssetID().equals(uId));
        if (uAsset == null) {
            System.out.println("Asset doesn not exist");
        } else {
            uAsset.setName(Validation.inputString("Input asset name: ", uAsset.getName()));
            uAsset.setColor(Validation.inputString("Input asset color: ", uAsset.getColor()));
            uAsset.setPrice(Validation.inputInt("Input asset price: ", uAsset.getPrice()));
            // chua cap nhat dung weight
            uAsset.setWeight(Validation.inputFloat("Input asset weight: ", uAsset.getWeight()));
            uAsset.setQuantity(Validation.inputInt("Input asset quantity: ", uAsset.getQuantity()));
            as.saveFile();
            System.out.println("Update successfully with" + uAsset.show());
        }
    }

    void approveRequest() {
        bs.loadFile();
        rs.loadFile();
        as.loadFile();
        showRequest();
        boolean statusApprove = false;

        String rId = Validation.inputString("Input request id you want to approve: ");
        Request request = rs.get(c -> c.getiD().equals(rId));
        if (request == null) {
            System.out.println("Request not exist");
        } else {
            Asset asset = as.get(c -> c.getAssetID().equals(request.getAssetID()));
            if (request.getQuantity() <= asset.getQuantity()) {
               // add new borrow
                Borrow borrow = new Borrow("B00" + (borrowList.size() + 1), request.getAssetID(), request.getEmployeeID(), request.getQuantity(), new Date());
                bs.add(borrow);
                //update quantity of asset
                asset.setQuantity(asset.getQuantity() - request.getQuantity());
                //delte request was aprroved
                statusApprove = rs.delete(c -> c.getiD().equals(request.getiD()));
            } else {
                System.out.println("Asset not enough quanity");
            }
        }
        if (statusApprove) {
            as.saveFile();
            bs.saveFile();
            rs.saveFile();
            System.out.println("Approve succefully");
        }

    }

    public void showRequest() {
        rs.loadFile();
        System.out.println("----Request list----");
        for (Request request : requestList) {
            System.out.println(request.show());
        }
    }

    void showBorrowList() {
        bs.loadFile();
        System.out.println("----Borrow List----");
        for (Borrow borrow : borrowList) {
            System.out.println(borrow.show());
        }
    }

    private String isAssetIdDuplicate(String id) {
        String result = id;
        boolean flag = true;
        for (Asset asset : assetlist) {
            if (asset.getAssetID().equals(id)) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println("Id is duplicate !!!");
            result = isAssetIdDuplicate(Validation.inputString("Input asset id: "));
        }
        return result;
    }

    void searchAssetWithWeight() {
        as.loadFile();
        float sWeight = Validation.inputFloat("Input wieght:");
        List<Asset> result = new ArrayList<>();
        for (int i = 0; i < assetlist.size(); i++) {
            Asset a = assetlist.get(i);
            if (a.getWeight() == sWeight) {
                result.add(a);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Can found");
            System.out.println("");
        } else {
            Collections.sort(result, (c1, c2) -> {
                int comp = c1.getAssetID().compareTo(c2.getAssetID());
                if (comp <= -1) {
                    return 1;
                } else if (comp == 0) {
                    return 0;
                }
                return -1;
            });
            System.out.println("---Asset List---");
            for (Asset a : result) {
                System.out.println(a.show());
            }
            System.out.println("");
        }
    }
}
