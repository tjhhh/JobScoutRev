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
    
    public void setHariWawancara(Date hariWawancara) {
        this.hariWawancara = hariWawancara;
    }

    public void setJamWawancara(String jamWawancara) {
        this.jamWawancara = jamWawancara;
    }
    
    public int getJumlahKaryawan(){
        return jumlahKaryawan;
    }

    public void setJumlahKaryawan(int jumlahKaryawan){
        this.jumlahKaryawan = jumlahKaryawan;
    }


    public void addLowongan(ArrayList<Lowongan> daftarLowongan){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Masukkan ID\t:");
            scanner.nextInt()
        }
    }  
    public void showLowongan(){
        System.out.println("ID: " + this.idLowongan);
        System.out.println("Judul : " + this.judulLowongan);
        System.out.println("Syarat Lowongan :" +this.syarat);
        System.out.println("Deskripsi Lowongan :" +this.deskripsi);
        System.out.println("Jumlah Karyawan : " + this.jumlahKaryawan);
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
              try(Scanner scanner = new Scanner(System.in)){
                System.out.println("Masukkan judul baru\t");
                String newJudul = scanner.nextLine();
                lowongan.setJudulLowongan(newJudul);
                
                System.out.println("Masukkan syarat baru\t");
                String newSyarat = scanner.nextLine();
                lowongan.setSyarat(newSyarat);
                
                System.out.println("Masukkan deskripsi baru\t");
                String newDesk = scanner.nextLine();
                lowongan.setDeskripsi(newDesk);

                System.out.println("Masukkan jumlah karyawan diterima\t");
                int newJKaryawan = scanner.nextInt();
                lowongan.setJumlahKaryawan(newJKaryawan);
              } catch(Exception e){
                    System.out.println("Terjadi kesalahan input\t: " + e.getMessage());
              }
          }else {
              System.out.println("Lowongan tidak ditemukan, akses tidak diberikan.");
          }
    }

    public void filterByNumberOfEmployee(ArrayList<Lowongan> daftarLowongan, int jumlahKaryawan){
        for(Lowongan lowongan : daftarLowongan){
            if(lowongan.getJumlahKaryawan() == jumlahKaryawan){
                lowongan.showLowongan();
            }
        }
    }

    public void showAllLowongan(ArrayList<Lowongan> daftarLowongan){
        int i = 1;
        for(Lowongan lowongan :daftarLowongan){
            System.out.println("Lowongan pekerjaan ke-" + i);
            lowongan.showLowongan();
            i++;
            System.out.println("");
        }
    }
}
