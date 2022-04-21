/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dto.Borrow;
import dto.Request;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import util.Validation;

/**
 *
 * @author Admin
 */
public class BorrowService extends BaseService<Borrow>{

    public BorrowService(String path, List<Borrow> list) {
        super(path, list);
    }

    @Override
    public void loadFile() {
        try {
            File file = new File(path);
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                list.clear();
                while (true) {
                    String data = br.readLine();
                    if (data == null) {
                        break;
                    }
                    this.list.add(createBrrow(data));
                }
                br.close();
                fr.close();
            } else {
                System.out.println("File is not exist !!!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private Borrow createBrrow(String data) throws ParseException {
        StringTokenizer stk = new StringTokenizer(data, ";");
        String bID = stk.nextToken();
        String assetID = stk.nextToken();
        String employeeID = stk.nextToken();
        int quantity = Integer.parseInt(stk.nextToken());
        Date requestDateTime = Validation.isFormatDateHasTime(stk.nextToken());
        
        return new Borrow(bID, assetID, employeeID, quantity, requestDateTime);
    }
    
}
