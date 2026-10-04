/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;

/**
 *
 * @author ASUS
 */
public class Volunter extends AnggotaPanitia {
    private String areaPenugasan;

    public Volunter(String nama, String npm, String divisi, String areaPenugasan) {
        super(nama, npm, divisi);
        this.areaPenugasan = areaPenugasan;
    }

    public void tampilkanInfo() {
        System.out.printf("[Volunter] Nama: %-18s | NPM: %-10s | Divisi: %-12s | Area Tugas: %s\n", 
            nama, npm, divisi, areaPenugasan);
    }

    public void jalankanTugas() {
        System.out.println("-> Bantuan Khusus: Membantu operasional di area " + areaPenugasan + ".");
    }
} 
