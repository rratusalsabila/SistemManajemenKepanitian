/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;

/**
 *
 * @author ASUS
 */
public class StafDivisi extends AnggotaPanitia {
    private String tugasSpesifik;

    public StafDivisi(String nama, String npm, String divisi, String tugasSpesifik) {
        super(nama, npm, divisi); 
        setTugasSpesifik(tugasSpesifik);
    }

    public String getTugasSpesifik() {
        return tugasSpesifik;
    }

    public void setTugasSpesifik(String tugasSpesifik) {
        if (tugasSpesifik != null && !tugasSpesifik.trim().isEmpty()) {
            this.tugasSpesifik = tugasSpesifik;
        } else {
            this.tugasSpesifik = "Pelaksana Lapangan";
        }
    }

    public void tampilkanInfo() {
        System.out.print("[STAF DIVISI ] ");
        super.tampilkanInfo(); 
        System.out.printf("| Tugas  : %-15s |\n", this.tugasSpesifik);
    }
}
