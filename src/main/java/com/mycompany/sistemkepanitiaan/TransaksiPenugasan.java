/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author ASUS
 */
public class TransaksiPenugasan {
    public static void prosesTugas(Anggota anggota, AnggotaPanitia panitia) {
        System.out.println("\n--- STRUK PENUGASAN ---");
        System.out.println("Peserta / Anggota : " + anggota.getNama() + " (" + anggota.getNpm() + ")");
        System.out.println("Panitia Bertugas  : " + panitia.getNama() + " (" + panitia.getDivisi() + ")");
        System.out.println("Status            : Penugasan berhasil dikoordinasikan di sistem.");
        panitia.jalankanTugas();
        System.out.println("------------------------");

        try (FileWriter pipaTulis = new FileWriter("log_penugasan.txt", true)) {
            String log = "Anggota: " + anggota.getNama() + " | Panitia: " + panitia.getNama() + " | Divisi: " + panitia.getDivisi() + "\n";
            pipaTulis.write(log);
        } catch (IOException e) {
            System.out.println("Peringatan: Gagal menulis log penugasan ke file. " + e.getMessage());
        }
    }
}
