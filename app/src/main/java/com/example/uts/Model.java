package com.example.uts;

/**
 * Tanggan Pengerjaan : 18 Mei 2019
 * NIM : 10116163
 * Nama : Anastasia Tania
 * Kelas : IF-4
 */

public class Model {
    String nama;
    int icon;

    //Constructor
    public Model (String nama, int icon){
        this.nama = nama;
        this.icon = icon;
    }

    //Getters

    public String getNama() {
        return this.nama;
    }

    public int getIcon() {
        return this.icon;
    }
}
