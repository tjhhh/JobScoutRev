package com.main;

public class AdminPerusahaan extends Pengguna{
    private int idPerusahaan;
    private int jumlahKaryawan;
    private String bidang;

    public AdminPerusahaan(int idPerusahaan, int jumlahKaryawan, String bidang, int idPengguna, String username, String password, int follower, int following) {
        super(idPengguna, username, password, follower, following);
        this.idPerusahaan = idPerusahaan;
        this.jumlahKaryawan = jumlahKaryawan;
        this.bidang = bidang;
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
    
}
