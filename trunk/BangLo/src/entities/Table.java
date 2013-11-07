/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author Ad
 */
public class Table {

    private ArrayList<So> soList;
    private String date;

    public Table(String date) {
        this.date = date;
        soList = new ArrayList<>();
    }

    public ArrayList<So> getSo() {
        return soList;
    }

    public void addSo(So so) {
        try {
            boolean isExist = false;
            for (So s : this.soList) {
                if (s.getKhach().equals(so.getKhach()) && s.getSo().equals(so.getSo())) {
                    s.setDiem(s.getDiem() + so.getDiem());
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                this.soList.add(so);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
