/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;

/**
 *
 * @author ASUS
 */
public class RuangRapat {
    private String namaRuangan;
    private int kapasitasKursi;

    public RuangRapat(String namaRuangan, int kapasitasKursi) {
        this.namaRuangan = namaRuangan;
        this.kapasitasKursi = kapasitasKursi;
    }

    public void bukaRuangan() {
        System.out.println("- " + namaRuangan + " dibuka. Kapasitas: " + kapasitasKursi + " kursi.");
    }
}
