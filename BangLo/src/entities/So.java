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
public class So {
    private String so;
    private int diem;
    private Customer khach;
    private String date;

    public So(String so, int diem, Customer khach, String date) {
        this.so = so;
        this.diem = diem;
        this.khach = khach;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Customer getKhach() {
        return khach;
    }

    public void setKhach(Customer khach) {
        this.khach = khach;
    }

    
}
