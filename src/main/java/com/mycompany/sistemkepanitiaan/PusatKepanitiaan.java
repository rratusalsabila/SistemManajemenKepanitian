/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class PusatKepanitiaan {
    private String namaEvent;
    private RuangRapat ruangRapatUtama; 
    private ArrayList<AnggotaPanitia> daftarPanitia; 
    private HashMap<String, Anggota> dataAnggota; 

    public PusatKepanitiaan(String namaEvent) {
        this.namaEvent = namaEvent;
        this.ruangRapatUtama = new RuangRapat("Ruang Rapat Utama", 50); 
        this.daftarPanitia = new ArrayList<>();
        this.dataAnggota = new HashMap<>();
    }

    public void bukaPusatKepanitiaan() {
        System.out.println("\n*** Menginisialisasi sistem " + this.namaEvent + " ***");
        ruangRapatUtama.bukaRuangan();
    }

    public void simpanDataKeFile() {
        try {
            FileOutputStream fileKeluar = new FileOutputStream("data_kepanitiaan.dat");
            ObjectOutputStream mesinPembeku = new ObjectOutputStream(fileKeluar);
            mesinPembeku.writeObject(this.daftarPanitia);
            mesinPembeku.writeObject(this.dataAnggota);
            mesinPembeku.close();
            System.out.println("-> [SYSTEM LOG] Seluruh data berhasil disimpan ke Harddisk!");
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal menyimpan data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void muatDataDariFile() {
        try {
            File cekFile = new File("data_kepanitiaan.dat");
            if (!cekFile.exists()) return;

            FileInputStream fileMasuk = new FileInputStream(cekFile);
            ObjectInputStream mesinPembangkit = new ObjectInputStream(fileMasuk);

            this.daftarPanitia = (ArrayList<AnggotaPanitia>) mesinPembangkit.readObject();
            this.dataAnggota = (HashMap<String, Anggota>) mesinPembangkit.readObject();

            AnggotaPanitia.setTotalPanitia(this.daftarPanitia.size());

            mesinPembangkit.close();
            System.out.println("-> [SYSTEM LOG] Data sistem berhasil dimuat ulang dari penyimpanan.");
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal memuat data: " + e.getMessage());
        }
    }

    public void bacaLogPenugasan() {
        System.out.println("\n--- Riwayat Log Penugasan ---");
        try {
            File fileLog = new File("log_penugasan.txt");
            if (!fileLog.exists()) {
                System.out.println("Belum ada log penugasan kepanitiaan.");
                return;
            }
            Scanner mesinBaca = new Scanner(fileLog);
            while (mesinBaca.hasNextLine()) {
                System.out.println(mesinBaca.nextLine());
            }
            mesinBaca.close();
        } catch (FileNotFoundException e) {
            System.out.println("Gagal membuka file log.");
        }
    }

    public void tambahPanitia(AnggotaPanitia p) {
        daftarPanitia.add(p);
        System.out.println("Sukses! Panitia ditambahkan. (Total Panitia: " + daftarPanitia.size() + ")");
    }

    public void tambahAnggota(Anggota a) {
        dataAnggota.put(a.getNpm(), a);
        System.out.println("Berhasil menambahkan anggota!");
    }

    public void lihatSemuaPanitia() {
        if (daftarPanitia.isEmpty()) {
            System.out.println("Belum ada panitia yang tersimpan.");
            return;
        }
        for (int i = 0; i < daftarPanitia.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarPanitia.get(i).tampilkanInfo();
            System.out.println();
        }
    }

    public void cariPanitia(String nama) throws PanitiaTidakDitemukanException {
        System.out.println("Mencari Panitia dengan Nama: " + nama);
        boolean ditemukan = false;
        for (AnggotaPanitia p : daftarPanitia) {
            if (p.getNama().equalsIgnoreCase(nama)) {
                p.tampilkanInfo();
                System.out.println();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new PanitiaTidakDitemukanException("Gagal: Panitia dengan nama \"" + nama + "\" tidak terdaftar di sistem.");
        }
    }

    public void cariAnggota(String npm) {
        if (dataAnggota.containsKey(npm)) {
            System.out.println("Ditemukan! Nama: " + dataAnggota.get(npm).getNama());
        } else {
            System.out.println("Anggota dengan NPM tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaAnggota() {
        System.out.println("Total Anggota Terdaftar: " + dataAnggota.size());
        for (Anggota a : dataAnggota.values()) {
            System.out.println("- NPM: " + a.getNpm() + " | Nama: " + a.getNama());
        }
    }

    public Anggota getAnggota(String npm) {
        return dataAnggota.get(npm);
    }

    public AnggotaPanitia getPanitiaInt(int index) {
        return daftarPanitia.get(index);
    }

    public int getJumlahPanitia() {
        return daftarPanitia.size();
    }
}