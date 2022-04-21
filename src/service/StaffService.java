/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dto.Employee;
import dto.Manager;
import dto.Staff;
import dto.StaffRole;
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
public class StaffService extends BaseService<Staff> {

    public StaffService(String path, List<Staff> list) {
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
                    this.list.add(createStaff(data));
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

    private Staff createStaff(String data) throws ParseException {
        StringTokenizer stk = new StringTokenizer(data, ";");
        String employID = stk.nextToken();
        String name = stk.nextToken();
        Date birthdate = Validation.isFormatDate(stk.nextToken(), "dd/MM/yyyy");
        StaffRole role = null;
        String sRole = stk.nextToken();
        if (sRole.equalsIgnoreCase(StaffRole.EM.toString())) {
            role = StaffRole.EM;
        }
        if (sRole.equalsIgnoreCase(StaffRole.MA.toString())) {
            role = StaffRole.MA;
        }
        String sex = stk.nextToken();
        String password = stk.nextToken();

        Staff staff = null;
        if (role.equals(StaffRole.MA)) {
            staff = new Manager(employID, name, sex, password, birthdate);
        }
        if (role.equals(StaffRole.EM)) {
            staff = new Employee(employID, name, sex, password, birthdate);
        }
        return staff;
    }

}
