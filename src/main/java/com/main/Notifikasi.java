package com.main;

import java.util.Date;
public class Notifikasi {
    private String message;
    private int idPengguna;
    private String type;  // Tipe notifikasi: bisa berupa status lamaran, wawancara, dsb.

    public Notifikasi(int idPengguna, String message, String type) {
        this.idPengguna = idPengguna;
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public String getType() {
        return type;
    }

    // Menampilkan notifikasi untuk pengguna
    public void sendNotification() {
        System.out.println("Notifikasi untuk Pengguna ID: " + this.idPengguna);
        System.out.println("Tipe Notifikasi: " + this.type);
        System.out.println("Pesan: " + this.message);
        System.out.println("=============================");
    }

    // Menampilkan pesan notifikasi terkait status lamaran
    public static void sendLamaranStatusNotification(Lamaran lamaran) {
        String message = "Lamaran Anda dengan ID " + lamaran.getIdLamaran() + " saat ini berstatus: " + lamaran.getStatusLamar();
        Notifikasi notification = new Notifikasi(lamaran.getIdPengguna(), message, "Status Lamaran");
        notification.sendNotification();
    }

    // Menampilkan pesan notifikasi untuk wawancara
    public static void sendInterviewNotification(Lowongan lowongan, Date interviewDate, String interviewTime) {
        String message = "Anda telah dijadwalkan wawancara untuk Lowongan " + lowongan.getJudulLowongan() + " pada tanggal " + interviewDate + " pukul " + interviewTime;
        Notifikasi notification = new Notifikasi(0, message, "Wawancara");
        notification.sendNotification();
    }

    // Menampilkan pesan notifikasi untuk perubahan status lamaran
    public static void sendApplicationStatusUpdate(Lamaran lamaran, String newStatus) {
        lamaran.updateStatusLamaran(newStatus);
        String message = "Status lamaran Anda dengan ID " + lamaran.getIdLamaran() + " telah diperbarui menjadi: " + newStatus;
        Notifikasi notification = new Notifikasi(lamaran.getIdPengguna(), message, "Status Update");
        notification.sendNotification();
    }

    // Menampilkan notifikasi untuk lowongan yang baru ditambahkan
    public static void sendNewJobNotification(Lowongan lowongan) {
        String message = "Lowongan baru telah ditambahkan: " + lowongan.getJudulLowongan() + ". Segera lamar pekerjaan ini!";
        Notifikasi notification = new Notifikasi(0, message, "Lowongan Baru");
        notification.sendNotification();
    }
}
