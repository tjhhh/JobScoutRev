package com.main;

public class Pelamar extends Pengguna{
    private int NIK;
    private int noHp;
    private int tglLahir;
    private int idDokumen;

    public Pelamar(int NIK, int noHp, int tglLahir, int idDokumen, int idPengguna, String username, String password, int follower, int following) {
        super(idPengguna, username, password, follower, following);
        this.NIK = NIK;
        this.noHp = noHp;
        this.tglLahir = tglLahir;
        this.idDokumen = idDokumen;
    }

    public int getNIK() {
        return NIK;
    }

    public void setNIK(int NIK) {
        this.NIK = NIK;
    }

    public int getNoHp() {
        return noHp;
    }

    public void setNoHp(int noHp) {
        this.noHp = noHp;
    }

    public int getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(int tglLahir) {
        this.tglLahir = tglLahir;
    }

    public int getIdDokumen() {
        return idDokumen;
    }

    public void setIdDokumen(int idDokumen) {
        this.idDokumen = idDokumen;
    }
}
