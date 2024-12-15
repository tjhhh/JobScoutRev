package com.main;

import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Lowongan {
    private int idLowongan;
    private String judulLowongan;
    private String syarat;
    private String deskripsi;
    private int jumlahKaryawan;
    private Date hariWawancara;
    private String jamWawancara;

    public Lowongan(int idLowongan, String judulLowongan, String syarat, String deskripsi, int jumlahKaryawan) {
        this.idLowongan = idLowongan;
        this.judulLowongan = judulLowongan;
        this.syarat = syarat;
        this.deskripsi = deskripsi;
        this.jumlahKaryawan = jumlahKaryawan;
    }

    public int getIdLowongan() {
        return idLowongan;
    }

    public String getJudulLowongan() {
        return judulLowongan;
    }

    public Date getHariWawancara() {
        return hariWawancara;
    }

    public String getJamWawancara() {
        return jamWawancara;
    }

    public String getSyarat() {
        return syarat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getJumlahKaryawan() {
        return jumlahKaryawan;
    }

    public void setIdLowongan(int idLowongan) {
        this.idLowongan = idLowongan;
    }

    public void setJudulLowongan(String judulLowongan) {
        this.judulLowongan = judulLowongan;
    }

    public void setSyarat(String syarat) {
        this.syarat = syarat;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setJumlahKaryawan(int jumlahKaryawan) {
        this.jumlahKaryawan = jumlahKaryawan;
    }

    public void setHariWawancara(Date hariWawancara) {
        this.hariWawancara = hariWawancara;
    }

    public void setJamWawancara(String jamWawancara) {
        this.jamWawancara = jamWawancara;
    }

    public void addLowongan(ArrayList<Lowongan> daftarLowongan) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Masukkan ID Lowongan: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            System.out.println("Masukkan judul baru: ");
            String newJudul = scanner.nextLine();

            System.out.println("Masukkan syarat baru: ");
            String newSyarat = scanner.nextLine();

            System.out.println("Masukkan deskripsi baru: ");
            String newDesk = scanner.nextLine();

            System.out.println("Masukkan jumlah karyawan diterima: ");
            int newJKaryawan = scanner.nextInt();

            Lowongan newLowongan = new Lowongan(id, newJudul, newSyarat, newDesk, newJKaryawan);
            daftarLowongan.add(newLowongan);
            System.out.println("Lowongan pekerjaan dengan id " + id + " berhasil ditambahkan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }

    public void showLowongan() {
        System.out.println("ID: " + this.idLowongan);
        System.out.println("Judul : " + this.judulLowongan);
        System.out.println("Syarat Lowongan: " + this.syarat);
        System.out.println("Deskripsi Lowongan: " + this.deskripsi);
        System.out.println("Jumlah Karyawan: " + this.jumlahKaryawan);
    }

    public void showJadwal() {
        System.out.println("Tanggal Wawancara: " + hariWawancara);
        System.out.println("Jam Wawancara: " + jamWawancara);
    }

    public Lowongan cariLowonganByName(ArrayList<Lowongan> daftarLowongan, String namaLowongan) {
        for (Lowongan lowongan : daftarLowongan) {
            if (lowongan.getJudulLowongan().equalsIgnoreCase(namaLowongan)) {
                return lowongan;
            }
        }
        return null;
    }

    public void editLowongan(ArrayList<Lowongan> daftarLowongan, String namaLowongan) {
        Lowongan lowongan = cariLowonganByName(daftarLowongan, namaLowongan);
        if (lowongan != null) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Masukkan judul baru: ");
                String newJudul = scanner.nextLine();
                lowongan.setJudulLowongan(newJudul);

                System.out.println("Masukkan syarat baru: ");
                String newSyarat = scanner.nextLine();
                lowongan.setSyarat(newSyarat);

                System.out.println("Masukkan deskripsi baru: ");
                String newDesk = scanner.nextLine();
                lowongan.setDeskripsi(newDesk);

                System.out.println("Masukkan jumlah karyawan diterima: ");
                int newJKaryawan = scanner.nextInt();
                lowongan.setJumlahKaryawan(newJKaryawan);
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan input: " + e.getMessage());
            }
        } else {
            System.out.println("Lowongan tidak ditemukan, akses tidak diberikan.");
        }
    }

    public void filterByNumberOfEmployee(ArrayList<Lowongan> daftarLowongan, int jumlahKaryawan) {
        for (Lowongan lowongan : daftarLowongan) {
            if (lowongan.getJumlahKaryawan() == jumlahKaryawan) {
                lowongan.showLowongan();
            }
        }
    }

    public void filterByInterviewDate(ArrayList<Lowongan> daftarLowongan, Date tanggal) {
        for (Lowongan lowongan : daftarLowongan) {
            if (lowongan.getHariWawancara().equals(tanggal)) {
                lowongan.showLowongan();
            }
        }
    }

    public void showAllLowongan(ArrayList<Lowongan> daftarLowongan) {
        int i = 1;
        for (Lowongan lowongan : daftarLowongan) {
            System.out.println("Lowongan pekerjaan ke-" + i);
            lowongan.showLowongan();
            i++;
            System.out.println("");
        }
    }

    public void sortLowonganByEmployeeNeeded(ArrayList<Lowongan> daftarLowongan) {
        // Sorting manually without using Comparator
        for (int i = 0; i < daftarLowongan.size() - 1; i++) {
            for (int j = i + 1; j < daftarLowongan.size(); j++) {
                if (daftarLowongan.get(i).getJumlahKaryawan() > daftarLowongan.get(j).getJumlahKaryawan()) {
                    // Swap
                    Lowongan temp = daftarLowongan.get(i);
                    daftarLowongan.set(i, daftarLowongan.get(j));
                    daftarLowongan.set(j, temp);
                }
            }
        }
        System.out.println("Lowongan telah diurutkan berdasarkan jumlah karyawan yang dibutuhkan.");
    }

    public void catatHasilWawancara(String hasil) {
        System.out.println("Hasil wawancara untuk Lowongan " + this.judulLowongan + ": " + hasil);
    }
}
