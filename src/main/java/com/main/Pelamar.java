package com.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Pelamar extends Pengguna {
    private int NIK;
    private int noHp;
    private int tglLahir;
    private int idDokumen;
    private ArrayList<Resume> daftarResume; // Menyimpan daftar resume milik pelamar
    private ArrayList<Lamaran> daftarLamaran;

    public Pelamar(int NIK, int noHp, int tglLahir, int idDokumen, int idPengguna, String username, String password, int follower, int following) {
        super(idPengguna, username, password, follower, following);
        this.NIK = NIK;
        this.noHp = noHp;
        this.tglLahir = tglLahir;
        this.idDokumen = idDokumen;
        this.daftarResume = new ArrayList<>();
        this.daftarLamaran = new ArrayList<>(); // Inisialisasi daftar lamaran
    }

    // Getter dan Setter
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

    public ArrayList<Resume> getDaftarResume() {
        return daftarResume;
    }

    // Menambahkan resume baru
    public void buatResume() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Tambahkan Resume");
            System.out.println("2. Hapus Resume");
            System.out.println("3. Lihat Semua Resume");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    // Input data untuk Resume baru
                    System.out.print("Masukkan ID Dokumen: ");
                    int idDokumen = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\n===== Skill =====");
                    System.out.print("Masukkan Nama Skill: ");
                    String skillName = scanner.nextLine();
                    System.out.print("Masukkan Tingkatan Skill: ");
                    String tingkatanLevel = scanner.nextLine();
                    Skill skill = new Skill(skillName, tingkatanLevel);

                    System.out.println("\n=====Pendidikan=====");
                    System.out.print("Masukkan Nama Universitas: ");
                    String school = scanner.nextLine();
                    System.out.print("Masukkan Gelar: ");
                    String degree = scanner.nextLine();
                    System.out.print("Masukkan Jurusan: ");
                    String fieldOfStudy = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Mulai: ");
                    String startDate = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Selesai: ");
                    String endDate = scanner.nextLine();
                    Pendidikan pendidikan = new Pendidikan(school, degree, fieldOfStudy, startDate, endDate);

                    System.out.println("\n===== Pengalaman =====");
                    System.out.print("Masukkan Posisi Jabatan: ");
                    String position = scanner.nextLine();
                    System.out.print("Masukkan Nama Perusahaan: ");
                    String company = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Mulai: ");
                    String pengalamanStartDate = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Selesai: ");
                    String pengalamanEndDate = scanner.nextLine();
                    System.out.print("Masukkan Deskripsi Pekerjaan: ");
                    String description = scanner.nextLine();
                    Pengalaman pengalaman = new Pengalaman(position, company, pengalamanStartDate, pengalamanEndDate, description);

                    Resume resume = new Resume(idDokumen, skill, pendidikan, pengalaman);
                    addResume(resume);
                    System.out.println("Resume berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.print("Masukkan ID Dokumen yang ingin dihapus: ");
                    int idHapus = scanner.nextInt();
                    removeResume(idHapus);
                    System.out.println("Resume berhasil dihapus!");
                    break;

                case 3:
                    listResumes();
                    break;

                case 4:
                    System.out.println("Keluar program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Menambahkan resume baru
    public void addResume(Resume resume) {
        daftarResume.add(resume);
    }

    // Mengubah informasi resume
    public boolean removeResume(int idDokumen) {
        return daftarResume.removeIf(resume -> resume.getIdDokumen() == idDokumen);
    }
    
    public void editResume(int idDokumen, Resume updatedResume) {
        for (int i = 0; i < daftarResume.size(); i++) {
            if (daftarResume.get(i).getIdDokumen() == idDokumen) {
                daftarResume.set(i, updatedResume);
                return;
            }
        }
    }
    

    public void listResumes() {
        if (daftarResume.isEmpty()) {
            System.out.println("Tidak ada resume yang tersedia.");
        } else {
            for (Resume resume : daftarResume) {
                resume.membuatResume();
            }
        }
    }
    // Method untuk melamar pekerjaan
    public void applyForJob(Lowongan lowongan) {
        Scanner scanner = new Scanner(System.in);

        // Cek apakah pelamar memenuhi syarat lowongan
        if (this.daftarResume.isEmpty()) {
            System.out.println("Anda belum memiliki resume. Harap buat resume terlebih dahulu.");
            return;
        }

        System.out.println("Melamar untuk lowongan: " + lowongan.getJudul());
        System.out.println("Apakah Anda memenuhi persyaratan lowongan ini? (Y/N)");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("Y")) {
            Lamaran lamaran = new Lamaran(this, lowongan);
            daftarLamaran.add(lamaran);
            System.out.println("Lamaran berhasil diajukan.");

            // Kirim notifikasi ke admin perusahaan
            Notifikasi notifikasi = new Notifikasi("Notif_" + lamaran.getIdLamaran(), lowongan.getAdminPerusahaan(), "Pelamar dengan NIK " + this.NIK + " telah melamar untuk lowongan " + lowongan.getJudul());
            lowongan.getAdminPerusahaan().getDaftarNotifikasi().add(notifikasi);  // Menambahkan notifikasi pada admin
        } else {
            System.out.println("Anda tidak memenuhi persyaratan atau memilih untuk tidak melamar.");
        }
    }
}
