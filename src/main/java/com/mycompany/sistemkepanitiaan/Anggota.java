/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;
import java.io.Serializable;
/**
 *
 * @author ASUS
 */
public class Anggota implements Serializable {
    private static final long serialVersionUID = 1L;
    private String npm;
    private String nama;

    public Anggota(String npm, String nama) {
        this.npm = npm;
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public String getNama() {
        return nama;
    }
}