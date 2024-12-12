package com.main;

public class Lamaran{
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

    public void applyJob(){
        this.statusLamar = "Pending";
        System.out.println("=====================");
        System.out.println("Pengguna dengan id\t:" + getIdPengguna());
        System.out.println("Melamar pekerjaan dengan deskripsi sebagai berikut :");
        System.out.println("Id Lowongan\t:" + lowongan.getIdLowongan());
        System.out.println("Nama Pekerjaan\t:" + lowongan.getJudulLowongan());
        System.out.println("Persyaratan\t:");
        System.out.println(lowongan.getSyarat());
        System.out.println("Deskripsi\t:");
        System.out.println(lowongan.getDeskripsi());
    }
    
}
