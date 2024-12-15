package com.main;

import java.util.ArrayList;

public class Rekomendasi {
    private int idRecommendation;
    private int idPengguna;
    private ArrayList<Lowongan> recommendedJobs;
    private boolean isFilled;  // Flag untuk memastikan data sudah terisi

    public Rekomendasi(int idRecommendation, int idPengguna) {
        this.idRecommendation = idRecommendation;
        this.idPengguna = idPengguna;
        this.recommendedJobs = new ArrayList<>();
        this.isFilled = true;  // Dianggap sudah terisi saat objek dibuat

        // Menambahkan lowongan secara langsung (statik)
        Lowongan lowongan1 = new Lowongan(1, "Software Engineer", "Syarat: S1 Teknik Informatika", "Deskripsi: Membangun aplikasi", 3);
        Lowongan lowongan2 = new Lowongan(2, "Data Scientist", "Syarat: S1 Matematika atau Statistik", "Deskripsi: Menganalisa data", 2);
        
        // Menambahkan lowongan ke daftar rekomendasi
        recommendedJobs.add(lowongan1);
        recommendedJobs.add(lowongan2);
    }

    public int getIdRecommendation() {
        return idRecommendation;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public ArrayList<Lowongan> getRecommendedJobs() {
        return recommendedJobs;
    }

    // Menampilkan rekomendasi lowongan untuk pengguna
    public void showRecommendations() {
        if (recommendedJobs.isEmpty()) {
            System.out.println("Tidak ada rekomendasi lowongan untuk pengguna dengan ID " + idPengguna);
        } else {
            System.out.println("Rekomendasi Lowongan untuk Pengguna ID: " + idPengguna);
            for (Lowongan lowongan : recommendedJobs) {
                System.out.println("ID Lowongan: " + lowongan.getIdLowongan());
                System.out.println("Judul Lowongan: " + lowongan.getJudulLowongan());
                System.out.println("Deskripsi: " + lowongan.getDeskripsi());
                System.out.println("Syarat: " + lowongan.getSyarat());
                System.out.println("Jumlah Karyawan yang Dibutuhkan: " + lowongan.getJumlahKaryawan());
                System.out.println("----------------------------");
            }
        }
    }
}
