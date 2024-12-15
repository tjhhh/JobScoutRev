package com.main;

import java.util.ArrayList;

public class Lamaran {
    private int idLamaran;
    private int tglLamar;
    private String statusLamar;
    private int idPengguna;
    private Lowongan lowongan;

    public Lamaran(int idLamaran, int tglLamar, String statusLamar, int idPengguna) {
        this.idLamaran = idLamaran;
        this.tglLamar = tglLamar;
        this.statusLamar = statusLamar;
        this.idPengguna = idPengguna;
    }

    public int getIdLamaran() {
        return idLamaran;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public String getStatusLamar() {
        return statusLamar;
    }

    public int getTglLamar() {
        return tglLamar;
    }

    public void applyJob() {
        this.statusLamar = "Pending";
        System.out.println("=====================");
        System.out.println("Pengguna dengan id: " + getIdPengguna());
        System.out.println("Melamar pekerjaan dengan deskripsi sebagai berikut:");
        System.out.println("Id Lowongan: " + lowongan.getIdLowongan());
        System.out.println("Nama Pekerjaan: " + lowongan.getJudulLowongan());
        System.out.println("Persyaratan:");
        System.out.println(lowongan.getSyarat());
        System.out.println("Deskripsi:");
        System.out.println(lowongan.getDeskripsi());
    }

    public void setLowongan(Lowongan lowongan) {
        this.lowongan = lowongan;
    }

    public void updateStatusLamaran(String status) {
        this.statusLamar = status;
        System.out.println("Status lamaran telah diperbarui menjadi: " + status);
    }

    public void beriFeedback(String feedback) {
        System.out.println("Feedback untuk lamaran id " + this.idLamaran + ": " + feedback);
    }
}
