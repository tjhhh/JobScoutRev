package com.main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Pelamar> daftarPelamar = new ArrayList<>();
    private static ArrayList<AdminPerusahaan> daftarAdminPerusahaan = new ArrayList<>();
    private static ArrayList<Lowongan> daftarLowongan = new ArrayList<>();
    private static ArrayList<Lamaran> daftarLamaran = new ArrayList<>();
    private static ArrayList<Notifikasi> daftarNotifikasi = new ArrayList<>();
    private static ArrayList<Rekomendasi> daftarRekomendasi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
        }
    }

    public static void showMainMenu() {
        System.out.println("Selamat datang di Sistem Lowongan Kerja");
        System.out.println("Pilih menu:");
        System.out.println("1. Buat Akun");
        System.out.println("2. Masuk");
        System.out.println("3. Keluar");
        
        int pilihan = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        switch (pilihan) {
            case 1:
                buatAkun();
                break;
            case 2:
                masuk();
                break;
            case 3:
                System.out.println("Terima kasih telah menggunakan sistem kami.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    public static void buatAkun() {
        System.out.println("Pilih jenis akun:");
        System.out.println("1. Pelamar");
        System.out.println("2. Admin Perusahaan");
        int pilihan = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        
        switch (pilihan) {
            case 1:
                // Membuat objek Scanner untuk membaca input
                Scanner scanner = new Scanner(System.in);

                // Mengambil input dari pengguna untuk masing-masing parameter
                System.out.print("Masukkan Username: ");
                String usernamePelamar = scanner.nextLine();

                System.out.print("Masukkan Password: ");
                String passwordPelamar = scanner.nextLine();

                System.out.print("Masukkan Nama: ");
                String namaPelamar = scanner.nextLine();

                System.out.print("Masukkan NIK: ");
                int nik = scanner.nextInt();

                System.out.print("Masukkan Umur: ");
                int umur = scanner.nextInt();

                System.out.print("Masukkan No. HP: ");
                int noHp = scanner.nextInt();

                System.out.print("Masukkan Tanggal Lahir (format: YYYY-MM-DD): ");
                String tglLahir = scanner.nextLine(); // bisa diproses menjadi objek Date nanti jika diperlukan

                // Membuat objek Pelamar dengan data yang diinputkan
                Pelamar pelamar = new Pelamar(namaPelamar,umur,nik, noHp, tglLahir, 000001, 100001, usernamePelamar,  passwordPelamar, 20, 100);
                
                
                daftarPelamar.add(pelamar);
                System.out.println("Akun pelamar berhasil dibuat!");
                break;
            case 2:
                
                // Mengambil input dari pengguna untuk masing-masing parameter
                System.out.print("Masukkan Username: ");
                String usernamePerusahaan = scanner.nextLine();

                System.out.print("Masukkan Password: ");
                String passwordPerusahaan = scanner.nextLine();

                System.out.print("Masukkan Nama Perusahaan: ");
                String namaPerusahaan = scanner.nextLine();

                System.out.print("Masukkan Bidang Perusahaan: ");
                int bidang = scanner.nextInt();

                System.out.print("Masukkan Umur: ");
                int jumlahKaryawan = scanner.nextInt();

                
                
                AdminPerusahaan admin = new AdminPerusahaan(200001, jumlahKaryawan,  bidang, 100001, usernamePerusahaan,  passwordPerusahaan,200, 15);
                daftarAdminPerusahaan.add(admin);
                System.out.println("Akun Admin Perusahaan berhasil dibuat!");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    public static void masuk() {
        System.out.println("Masukkan jenis akun:");
        System.out.println("1. Pelamar");
        System.out.println("2. Admin Perusahaan");
        int pilihan = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        switch (pilihan) {
            case 1:
                loginPelamar();
                break;
            case 2:
                loginAdminPerusahaan();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    public static void loginPelamar() {
        System.out.println("Masukkan nama pelamar:");
        String nama = scanner.nextLine();
        Pelamar pelamar = cariPelamar(nama);
        if (pelamar != null) {
            showPelamarMenu(pelamar);
        } else {
            System.out.println("Pelamar tidak ditemukan.");
        }
    }

    public static void loginAdminPerusahaan() {
        System.out.println("Masukkan nama Admin Perusahaan:");
        String nama = scanner.nextLine();
        AdminPerusahaan admin = cariAdminPerusahaan(nama);
        if (admin != null) {
            showAdminPerusahaanMenu(admin);
        } else {
            System.out.println("Admin Perusahaan tidak ditemukan.");
        }
    }

    public static Pelamar cariPelamar(String nama) {
        for (Pelamar pelamar : daftarPelamar) {
            if (pelamar.getNama().equalsIgnoreCase(nama)) {
                return pelamar;
            }
        }
        return null;
    }

    public static AdminPerusahaan cariAdminPerusahaan(String nama) {
        for (AdminPerusahaan admin : daftarAdminPerusahaan) {
            if (admin.getNamaPT().equalsIgnoreCase(nama)) {
                return admin;
            }
        }
        return null;
    }

    public static void showPelamarMenu(Pelamar pelamar) {
        while (true) {
            System.out.println("\nMenu Pelamar:");
            System.out.println("1. Lihat Rekomendasi Lowongan");
            System.out.println("2. Lihat Notifikasi");
            System.out.println("3. Buat Resume");
            System.out.println("4. Apply Lowongan");
            System.out.println("5. Kembali ke Menu Utama");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (pilihan) {
                case 1:
                    pelamar.lihatRekomendasi();
                    break;
                case 2:
                    pelamar.lihatNotifikasi();
                    break;
                case 3:
                    pelamar.buatResume();
                    break;
                case 4:
                    pelamar.applyLowongan();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void showAdminPerusahaanMenu(AdminPerusahaan admin) {
        while (true) {
            System.out.println("\nMenu Admin Perusahaan:");
            System.out.println("1. Buat Lowongan Pekerjaan");
            System.out.println("2. Kelola Event");
            System.out.println("3. Proses Lamaran");
            System.out.println("4. Kembali ke Menu Utama");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (pilihan) {
                case 1:
                    admin.buatLowongan();
                    break;
                case 2:
                    admin.kelolaEvent();
                    break;
                case 3:
                    admin.prosesLamaran();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
