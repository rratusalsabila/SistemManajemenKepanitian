/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner; 
/**
 *
 * @author ASUS
 */
public class SistemKepanitiaan {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PusatKepanitiaan perpusUnila = new PusatKepanitiaan("Sistem Kepanitiaan Event Unila");
        perpusUnila.bukaPusatKepanitiaan();

        boolean isRunning = true;

        System.out.println("==================================================");
        System.out.println("   SISTEM MANAJEMEN KEPANITIAAN EVENT MAHASISWA   ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Tambah Panitia");
            System.out.println("2. Lihat Daftar Panitia");
            System.out.println("3. Cari Panitia");
            System.out.println("4. Manajemen Anggota");
            System.out.println("5. Peminjaman / Penugasan (Demo Association)");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu: 1-6: ");

            try {
                if (!scanner.hasNextInt()) {
                    System.out.println("Input harus angka!");
                    scanner.nextLine();
                    continue;
                }

                int pilihan = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n--- Pilih Tipe Panitia ---");
                        System.out.println("1. Panitia Inti");
                        System.out.println("2. Staf Divisi");
                        System.out.println("3. Volunter");
                        System.out.print("Pilihan (1/2/3): ");
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
                            perpusUnila.tambahPanitia(new PanitiaInti(nama, npm, divisi, jabatan));
                        } else if (tipe == 2) {
                            System.out.print("Masukkan Tugas Spesifik: ");
                            String tugas = scanner.nextLine();
                            perpusUnila.tambahPanitia(new StafDivisi(nama, npm, divisi, tugas));
                        } else if (tipe == 3) {
                            System.out.print("Masukkan Area Penugasan: ");
                            String area = scanner.nextLine();
                            perpusUnila.tambahPanitia(new Volunter(nama, npm, divisi, area));
                        } else {
                            System.out.println("Pilihan tipe tidak valid.");
                        }
                    }

                    case 2 -> {
                        System.out.println("\n--- DAFTAR PANITIA EVENT ---");
                        perpusUnila.lihatSemuaPanitia();
                    }

                    case 3 -> {
                        System.out.println("\n--- Fitur Cari Panitia ---");
                        System.out.print("Masukkan Nama: ");
                        String kataKunci = scanner.nextLine();
                        try {
                            perpusUnila.cariPanitia(kataKunci);
                        } catch (PanitiaTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        System.out.println("\n--- Kelola Anggota ---");
                        System.out.println("1. Tambah Anggota");
                        System.out.println("2. Cari Anggota");
                        System.out.println("3. Lihat Semua");
                        System.out.print("Pilih: ");
                        int menuA = scanner.nextInt();
                        scanner.nextLine();

                        if (menuA == 1) {
                            System.out.print("Masukkan NPM: ");
                            String npm = scanner.nextLine();
                            System.out.print("Masukkan Nama: ");
                            String nama = scanner.nextLine();
                            perpusUnila.tambahAnggota(new Anggota(npm, nama));
                        } else if (menuA == 2) {
                            System.out.print("NPM yg dicari: ");
                            perpusUnila.cariAnggota(scanner.nextLine());
                        } else if (menuA == 3) {
                            perpusUnila.lihatSemuaAnggota();
                        }
                    }

                    case 5 -> {
                        System.out.println("\n--- Sistem Penugasan (Asosiasi) ---");
                        System.out.print("Masukkan NPM Peminjam / Anggota: ");
                        String inputNpm = scanner.nextLine();
                        Anggota peminjam = perpusUnila.getAnggota(inputNpm);

                        if (peminjam == null) {
                            System.out.println("Gagal: Anggota belum terdaftar!");
                        } else if (perpusUnila.getJumlahPanitia() == 0) {
                            System.out.println("Gagal: Belum ada panitia yang bisa dikoordinasikan.");
                        } else {
                            perpusUnila.lihatSemuaPanitia();
                            System.out.print("Pilih Nomor Panitia yang ingin dikoordinasikan: ");
                            int noPanitia = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noPanitia >= 0 && noPanitia < perpusUnila.getJumlahPanitia()) {
                                AnggotaPanitia itemPanitia = perpusUnila.getPanitiaInt(noPanitia);
                                TransaksiPenugasan.prosesTugas(peminjam, itemPanitia);
                            } else {
                                System.out.println("Nomor panitia tidak valid!");
                            }
                        }
                    }

                    case 6 -> {
                        System.out.println("Terima kasih telah menggunakan Sistem Manajemen Kepanitiaan!");
                        isRunning = false;
                    }

                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
        scanner.close();
    }
}