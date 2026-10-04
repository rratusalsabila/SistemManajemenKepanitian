/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;

/**
 *
 * @author ASUS
 */
public class PanitiaInti extends AnggotaPanitia {
    private String jabatan;

    public PanitiaInti(String nama, String npm, String divisi, String jabatan) {
        super(nama, npm, divisi);
        this.jabatan = jabatan;
    }
    
    public void tampilkanInfo() {
        System.out.printf("[Panitia Inti]   Nama: %-18s | NPM: %-10s | Divisi: %-12s | Jabatan: %s\n", 
            nama, npm, divisi, jabatan);
    }

    public void jalankanTugas() {
        System.out.println("-> Tanggung Jawab Inti: Mengoordinasikan rangkaian acara dan mengambil keputusan strategis.");
    }
}
