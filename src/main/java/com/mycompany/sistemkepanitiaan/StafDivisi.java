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
        this.tugasSpesifik = tugasSpesifik;
    }

    public void tampilkanInfo() {
        System.out.printf("[Staf Divisi]    Nama: %-18s | NPM: %-10s | Divisi: %-12s | Tugas: %s\n", 
            nama, npm, divisi, tugasSpesifik);
    }

    @Override
    public void jalankanTugas() {
        System.out.println("-> Eksekusi Lapangan: " + tugasSpesifik);
    }
}
