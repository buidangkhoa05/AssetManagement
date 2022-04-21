/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import util.Validation;

/**
 *
 * @author Admin
 */
public abstract class BaseService<T> implements IService<T>{

    protected String path;
    protected List<T> list;

    public BaseService(String path, List<T> list) {
        this.path = path;
        this.list = list;
    }

    @Override
    public void saveFile() {
        File file = new File(path);
        try {
            if (file.exists()) {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                if (!list.isEmpty()) {
                    for (T t : list) {
                        bw.append(t.toString());
                        bw.newLine();
                    }
                } else {
                    System.out.println("List is empty");
                }
                bw.close();
                fw.close();
            } else {
                System.out.println("File have problem");
            }
            System.out.println("Save file succesful");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Save file not successful");
        }
    }

    public void add(T t) {
        list.add(t);
    }

    public boolean update(T t, Predicate<? super T> predicate) {
        T currentObject = get(predicate);
        if (currentObject != null) {
            int index = list.indexOf(currentObject);
            list.set(index, t);
            System.out.println(list.get(index));
            return true;
        }
        return false;
    }
    
    public boolean delete(Predicate<? super T> predicate) {
        T currentObject = get(predicate);
        if (currentObject != null) {
            list.remove(currentObject);
            return true;
        }
        return false;
    }

    public T get(Predicate<? super T> predicate) {
        List<T> result = list.stream().filter(predicate).collect(Collectors.toList());
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public List<T> getAll(Predicate<? super T> predicate) {
        List<T> result = list.stream().filter(predicate).collect(Collectors.toList());
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    public List<T> getAll() {
        return this.list;
    }  


}
