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
        setJabatan(jabatan);
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        if (jabatan != null && !jabatan.trim().isEmpty()) {
            this.jabatan = jabatan;
        } else {
            this.jabatan = "Anggota Inti";
        }
    }
    public void tampilkanInfo() {
        System.out.print("[PANITIA INTI] ");
        super.tampilkanInfo();
        System.out.printf("| Jabatan: %-15s |\n", this.jabatan);
    }
}
