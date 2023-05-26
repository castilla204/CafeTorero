/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author PC
 */
//T - tipo relacionado a la tabla
public interface DAO<T> {
    List<T> findAll();
    T get(int id);
    void delete(int id);
    void update(T t);
    void insert(T t);
}
