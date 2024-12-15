package com.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class AdminPerusahaan extends Pengguna {
    private String namaPT;
    private int idPerusahaan;
    private int jumlahKaryawan;
    private String bidang;
    private ArrayList<Lowongan> daftarLowongan;
    private ArrayList<Event> daftarEvent;

    public AdminPerusahaan(int idPerusahaan, int jumlahKaryawan, String bidang, int idPengguna, String username, String password, int follower, int following) {
        super(idPengguna, username, password, follower, following);
        this.namaPT = namaPT;
        this.idPerusahaan = idPerusahaan;
        this.jumlahKaryawan = jumlahKaryawan;
        this.bidang = bidang;
        this.daftarLowongan = new ArrayList<>();
        this.daftarEvent = new ArrayList<>();
    }

    public void setNamaPT(String namaPT){
        this.namaPT = namaPT;
    }
    public String getNamaPT(){
        return namaPT;
    }
    public int getIdPerusahaan() {
        return idPerusahaan;
    }

    public void setIdPerusahaan(int idPerusahaan) {
        this.idPerusahaan = idPerusahaan;
    }

    public int getJumlahKaryawan() {
        return jumlahKaryawan;
    }

    public void setJumlahKaryawan(int jumlahKaryawan) {
        this.jumlahKaryawan = jumlahKaryawan;
    }

    public String getBidang() {
        return bidang;
    }

    public void setBidang(String bidang) {
        this.bidang = bidang;
    }

    public ArrayList<Lowongan> getDaftarLowongan() {
        return daftarLowongan;
    }

    // Method untuk membuat lowongan pekerjaan
    public void createLowongan(ArrayList<Lowongan> daftarLowongan) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Masukkan ID Lowongan: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // untuk membersihkan newline

            System.out.println("Masukkan Judul Lowongan: ");
            String judul = scanner.nextLine();

            System.out.println("Masukkan Syarat Lowongan: ");
            String syarat = scanner.nextLine();

            System.out.println("Masukkan Deskripsi Lowongan: ");
            String deskripsi = scanner.nextLine();

            System.out.println("Masukkan Jumlah Karyawan yang Diterima: ");
            int jumlahKaryawan = scanner.nextInt();

            // Membuat objek Lowongan dan menambahkannya ke daftar
            Lowongan lowongan = new Lowongan(id, judul, syarat, deskripsi, jumlahKaryawan);
            daftarLowongan.add(lowongan);

            System.out.println("Lowongan pekerjaan berhasil ditambahkan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }

    // Method untuk mengedit lowongan pekerjaan
    public void editLowongan(ArrayList<Lowongan> daftarLowongan) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Masukkan Judul Lowongan yang ingin diedit: ");
            String namaLowongan = scanner.nextLine();

            Lowongan lowongan = new Lowongan(0, "", "", "", 0); // Membuat objek Lowongan untuk mencari
            lowongan.editLowongan(daftarLowongan, namaLowongan); // Memanggil method editLowongan dari Lowongan
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }

    // Method untuk menampilkan semua lowongan
    public void showAllLowongan(ArrayList<Lowongan> daftarLowongan) {
        Lowongan lowongan = new Lowongan(0, "", "", "", 0);
        lowongan.showAllLowongan(daftarLowongan); // Memanggil method showAllLowongan dari Lowongan
    }

    // Method untuk membuat event
    public void createEvent(ArrayList<Event> daftarEvent) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Masukkan ID Event: ");
            int idEvent = scanner.nextInt();
            scanner.nextLine();  // untuk membersihkan newline

            System.out.println("Masukkan Nama Event: ");
            String eventName = scanner.nextLine();

            System.out.println("Masukkan Tanggal Event (dd-mm-yyyy): ");
            String tanggal = scanner.nextLine();
            Date eventDate = new Date(tanggal); // Anda bisa menyesuaikan format tanggal sesuai kebutuhan

            System.out.println("Masukkan Lokasi Event: ");
            String location = scanner.nextLine();

            System.out.println("Masukkan Deskripsi Event: ");
            String description = scanner.nextLine();

            System.out.println("Masukkan Nama Organiser Event: ");
            String organizer = scanner.nextLine();

            // Membuat objek Event dan menambahkannya ke daftar
            Event event = new Event(idEvent, eventName, eventDate, location, description, organizer, getIdPengguna());
            daftarEvent.add(event);

            System.out.println("Event berhasil ditambahkan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }

    // Method untuk mengubah event
    public void updateEvent(ArrayList<Event> daftarEvent) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Masukkan ID Event yang ingin diubah: ");
            int idEvent = scanner.nextInt();
            scanner.nextLine();  // untuk membersihkan newline

            System.out.println("Masukkan Nama Event baru: ");
            String eventName = scanner.nextLine();

            System.out.println("Masukkan Tanggal Event baru (dd-mm-yyyy): ");
            String tanggal = scanner.nextLine();
            Date eventDate = new Date(tanggal); // Sesuaikan format tanggal

            System.out.println("Masukkan Lokasi Event baru: ");
            String location = scanner.nextLine();

            System.out.println("Masukkan Deskripsi Event baru: ");
            String description = scanner.nextLine();

            System.out.println("Masukkan Nama Organiser Event baru: ");
            String organizer = scanner.nextLine();

            Event event = new Event(0, "", null, "", "", "", 0);
            event.updateEvent(idEvent, eventName, eventDate, location, description, organizer, getIdPengguna());
            System.out.println("Event berhasil diperbarui.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }

    // Method untuk menghapus event
    public void cancelEvent(ArrayList<Event> daftarEvent) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Masukkan ID Event yang ingin dibatalkan: ");
            int idEvent = scanner.nextInt();
            scanner.nextLine();  // untuk membersihkan newline

            Event event = new Event(0, "", null, "", "", "", 0);
            event.cancelEvent(daftarEvent, idEvent); // Memanggil method cancelEvent dari Event
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }
}
