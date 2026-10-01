/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemkepanitiaan;

import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class SistemKepanitiaan {
    public static void cariPanitia(String nama, AnggotaPanitia[] daftar, int jumlah) {
        System.out.println("\n=== Hasil Pencarian Nama: \"" + nama + "\" ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                daftar[i].tampilkanInfo(); 
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data panitia tidak ditemukan.");
        }
    }

    public static void cariPanitia(String divisi, AnggotaPanitia[] daftar, int jumlah, boolean isDivisi) {
        System.out.println("\n=== Hasil Pencarian Divisi: \"" + divisi + "\" ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getDivisi().equalsIgnoreCase(divisi)) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data panitia pada divisi tersebut tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnggotaPanitia[] daftarPanitia = new AnggotaPanitia[50]; 
        int jumlahPanitia = 0;

        daftarPanitia[jumlahPanitia++] = new PanitiaInti("Ahmad Rizky", "2517051001", "BPH", "Ketua Pelaksana");
        daftarPanitia[jumlahPanitia++] = new StafDivisi("Siti Nurhaliza", "2517051015", "Medinfo", "Desain Banner");
        daftarPanitia[jumlahPanitia++] = new StafDivisi("Budi Santoso", "2517051030", "Humas", "Broadcast Jarkom");

        boolean isRunning = true;

        System.out.println("==================================================");
        System.out.println("   SISTEM MANAJEMEN KEPANITIAAN EVENT MAHASISWA   ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Tambah Panitia Baru");
            System.out.println("2. Tampilkan Seluruh Daftar Panitia");
            System.out.println("3. Cari Panitia");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input harus angka!");
                scanner.nextLine();
                continue;
            }

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (pilihan) {
                case 1 -> {
                    if (jumlahPanitia >= daftarPanitia.length) {
                        System.out.println("Kapasitas daftar panitia penuh!");
                        break;
                    }

                    System.out.println("\n--- Pilih Subclass / Tipe Panitia ---");
                    System.out.println("1. Panitia Inti (BPH)");
                    System.out.println("2. Staf Divisi");
                    System.out.print("Pilihan (1/2): ");
                    int tipe = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan Nama   : ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NPM    : ");
                    String npm = scanner.nextLine();
                    System.out.print("Masukkan Divisi : ");
                    String divisi = scanner.nextLine();

                    if (tipe == 1) {
                        System.out.print("Masukkan Jabatan: ");
                        String jabatan = scanner.nextLine();
                        daftarPanitia[jumlahPanitia++] = new PanitiaInti(nama, npm, divisi, jabatan);
                        System.out.println("Sukses: Panitia Inti berhasil ditambahkan!");
                    } else if (tipe == 2) {
                        System.out.print("Masukkan Tugas Spesifik: ");
                        String tugas = scanner.nextLine();
                        daftarPanitia[jumlahPanitia++] = new StafDivisi(nama, npm, divisi, tugas);
                        System.out.println("Sukses: Staf Divisi berhasil ditambahkan!");
                    } else {
                        System.out.println("Pilihan tipe tidak valid.");
                    }
                }

                case 2 -> {
                    System.out.println("\n===================================================================================================");
                    System.out.println("                                      DAFTAR PANITIA EVENT                                         ");
                    System.out.println("===================================================================================================");
                    if (jumlahPanitia == 0) {
                        System.out.println("Belum ada data panitia.");
                    } else {
                        for (int i = 0; i < jumlahPanitia; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarPanitia[i].tampilkanInfo();
                        }
                    }
                    System.out.println("===================================================================================================");
                    System.out.println("Total Objek Panitia Dibuat (Static): " + AnggotaPanitia.getTotalPanitia());
                    System.out.println("===================================================================================================");
                }

                case 3 -> {
                    System.out.println("\n--- Menu Pencarian (Method Overloading) ---");
                    System.out.println("1. Cari Berdasarkan Nama");
                    System.out.println("2. Cari Berdasarkan Divisi");
                    System.out.print("Pilihan (1/2): ");
                    int optCari = scanner.nextInt();
                    scanner.nextLine();

                    if (optCari == 1) {
                        System.out.print("Masukkan Nama Panitia: ");
                        String namaCari = scanner.nextLine();
                        cariPanitia(namaCari, daftarPanitia, jumlahPanitia); 
                    } else if (optCari == 2) {
                        System.out.print("Masukkan Nama Divisi: ");
                        String divisiCari = scanner.nextLine();
                        cariPanitia(divisiCari, daftarPanitia, jumlahPanitia, true); 
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }

                case 4 -> {
                    System.out.println("\nProgram selesai. Terima kasih!");
                    isRunning = false;
                }

                default -> System.out.println("Pilihan menu tidak valid.");
            }
        }
        scanner.close();
    }
}