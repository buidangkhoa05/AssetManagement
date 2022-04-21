/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dto.Asset;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class AssetService extends BaseService<Asset> {

    public AssetService(String path, List<Asset> list) {
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
                    this.list.add(createAsset(data));
                }
                br.close();
                fr.close();
            } else {
                System.out.println("File is not exist !!!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            list.clear();
        }
    }

    public  Asset createAsset(String data) {
        StringTokenizer stk = new StringTokenizer(data, ";");
        String assetID = stk.nextToken();
        String name = stk.nextToken();
        String color = stk.nextToken();
        int price = Integer.parseInt(stk.nextToken());
        float weight = Float.parseFloat(stk.nextToken());
        int quantity = Integer.parseInt(stk.nextToken());
        return new Asset(assetID, name, color, price, weight, quantity);
    }
}
