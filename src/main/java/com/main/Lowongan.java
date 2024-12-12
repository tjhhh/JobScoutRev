package com.main;

import java.util.ArrayList;
import java.util.Scanner;
public class Lowongan {
    private int idLowongan;
    private String judulLowongan;
    private String syarat;
    private String deskripsi;
    private String hariWawancara;
    private String jamWawancara;

    public Lowongan(int idLowongan, String judulLowongan, String syarat, String deskripsi) {
        this.idLowongan = idLowongan;
        this.judulLowongan = judulLowongan;
        this.syarat = syarat;
        this.deskripsi = deskripsi;
    }
    
    public int getIdLowongan() {
        return idLowongan;
    }

    public String getJudulLowongan() {
        return judulLowongan;
    }

    public String getHariWawancara() {
        return hariWawancara;
    }

    public String getJamWawancara() {
        return jamWawancara;
    }

    public String getSyarat() {
        return syarat;
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

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public void setHariWawancara(String hariWawancara) {
        this.hariWawancara = hariWawancara;
    }

    public void setJamWawancara(String jamWawancara) {
        this.jamWawancara = jamWawancara;
    }
    
         
    public void showLowongan(){
        System.out.println("ID: " + this.idLowongan);
        System.out.println("Judul: " + this.judulLowongan);
        System.out.println("Syarat Lowongan" +this.syarat);
        System.out.println("Deskripsi Lowongan" +this.deskripsi);
    }
    
    public void showJadwal(){
            System.out.println("Tanggal Wawancara" + hariWawancara);
            System.out.println("Jam Wawancara" + jamWawancara);
    }   
   
    public Lowongan cariLowonganByName(ArrayList<Lowongan> daftarLowongan, String namaLowongan) {
        for (Lowongan lowongan : daftarLowongan) {
            if (lowongan.getJudulLowongan().equalsIgnoreCase(namaLowongan)) {
                return lowongan;
            }
        }
        return null;
    }
    
    public void editLowongan(ArrayList<Lowongan> daftarLowongan, String namaLowongan){
          Lowongan lowongan = cariLowonganByName(daftarLowongan, namaLowongan);
          if(lowongan != null) {
              Scanner scanner = new Scanner(System.in);
              
              System.out.println("Masukkan judul baru\t");
              String newJudul = scanner.nextLine();
              lowongan.setJudulLowongan(newJudul);
              
              System.out.println("Masukkan syarat baru\t");
              String newSyarat = scanner.nextLine();
              lowongan.setJudulLowongan(newSyarat);
              
              System.out.println("Masukkan deskripsi baru\t");
              String newDesk = scanner.nextLine();
              lowongan.setJudulLowongan(newDesk);
          }else {
              System.out.println("Lowongan tidak ditemukan, akses tidak diberikan.");
          }
    }
}
