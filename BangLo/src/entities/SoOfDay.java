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
public class SoOfDay {

    private String date;
    private String so;
    private int diem;
    private ArrayList<Integer> khachID;

    public SoOfDay(String date, String so) {
        this.date = date;
        this.so = so;
        this.khachID = new ArrayList<Integer>();
    }

    public void moreSo(So so) {
        if (so.getSo().equals(this.so)&&so.getDate().equals(this.date)) {
            if (!this.khachID.contains(so.getKhach().getId())) {
                this.khachID.add(so.getKhach().getId());
            }
            this.diem+=so.getDiem();
        }
    }

    public String getDate() {
        return date;
    }

    public String getSo() {
        return so;
    }

    public int getDiem() {
        return diem;
    }

    public ArrayList<Integer> getKhachID() {
        return khachID;
    }

}
