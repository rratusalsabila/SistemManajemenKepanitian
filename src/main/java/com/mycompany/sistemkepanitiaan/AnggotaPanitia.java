/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;

/**
 *
 * @author ASUS
 */
public class AnggotaPanitia {
    private String nama;
    private String npm;
    private String divisi;
    
    private static int totalPanitia = 0;
    
    public AnggotaPanitia(String nama, String npm, String divisi) {
        setNama(nama);
        setNpm(npm);
        setDivisi(divisi);
        totalPanitia++;
    }
    
   public static int getTotalPanitia() {
       return totalPanitia;
   }
   
   public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            this.nama = "Tanpa Nama";
        }
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        if (npm != null && !npm.trim().isEmpty()) {
            this.npm = npm;
        } else {
            this.npm = "0000000000";
        }
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        if (divisi != null && !divisi.trim().isEmpty()) {
            this.divisi = divisi;
        } else {
            this.divisi = "Umum";
        }
    }
    
    public void tampilkanInfo() {
        System.out.printf ("| %-18s | %-10s | %-12s ", this.divisi, this.npm, this.divisi);
    }

}
