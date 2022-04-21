/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Admin
 */
public interface IService<T> {
    public void loadFile();
    public void saveFile();
    public void add(T t);
    public boolean update(T t, Predicate<? super T> predicate);
    public boolean delete(Predicate<? super T> predicate);
    public T get(Predicate<? super T> predicate);
   public List<T> getAll(Predicate<? super T> predicate);
   public List<T> getAll();
   
}
