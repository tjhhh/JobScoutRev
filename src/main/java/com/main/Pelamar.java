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
    public void addResume() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan ID Dokumen: ");
        int idDokumen = scanner.nextInt();
        scanner.nextLine(); // Menangani nextLine setelah nextInt

        // Input Skill
        System.out.println("Masukkan Skill: ");
        String skillName = scanner.nextLine();
        System.out.println("Masukkan Tingkatan Skill: ");
        String tingkatanLevel = scanner.nextLine();
        Skill skill = new Skill(skillName, tingkatanLevel);

        // Input Pendidikan
        System.out.println("Masukkan Nama Sekolah: ");
        String school = scanner.nextLine();
        System.out.println("Masukkan Gelar: ");
        String degree = scanner.nextLine();
        System.out.println("Masukkan Jurusan: ");
        String fieldOfStudy = scanner.nextLine();
        System.out.println("Masukkan Tanggal Mulai (yyyy-mm-dd): ");
        String startDate = scanner.nextLine();
        System.out.println("Masukkan Tanggal Selesai (yyyy-mm-dd): ");
        String endDate = scanner.nextLine();
        Pendidikan pendidikan = new Pendidikan(school, degree, fieldOfStudy, startDate, endDate);

        // Input Pengalaman
        System.out.println("Masukkan Posisi: ");
        String position = scanner.nextLine();
        System.out.println("Masukkan Nama Perusahaan: ");
        String company = scanner.nextLine();
        System.out.println("Masukkan Tanggal Mulai (yyyy-mm-dd): ");
        String expStartDate = scanner.nextLine();
        System.out.println("Masukkan Tanggal Selesai (yyyy-mm-dd): ");
        String expEndDate = scanner.nextLine();
        System.out.println("Masukkan Deskripsi Pengalaman: ");
        String description = scanner.nextLine();
        Pengalaman pengalaman = new Pengalaman(position, company, expStartDate, expEndDate, description);

        // Membuat resume dan menambahkannya ke daftar
        Resume resume = new Resume(idDokumen, skill, pendidikan, pengalaman);
        daftarResume.add(resume);

        System.out.println("Resume berhasil ditambahkan!");
    }

    // Mengubah informasi resume
    public void editResume(int idDokumen) {
        Scanner scanner = new Scanner(System.in);
        Resume resumeToEdit = null;
        boolean resumeFound = false;
    
        // Mencari resume berdasarkan ID
        for (Resume resume : daftarResume) {
            if (resume.getIdDokumen() == idDokumen) {
                resumeToEdit = resume;
                resumeFound = true;
                // Set flag ke true jika resume ditemukan
            }
        }
    
        // Mengecek apakah resume ditemukan atau tidak
        if (resumeFound) {
            // Proses pengeditan
            System.out.println("Resume ditemukan. Silakan lakukan perubahan:");
    
            // Edit Pendidikan
            System.out.println("Masukkan informasi pendidikan baru:");
            System.out.println("Sekolah: ");
            String school = scanner.nextLine();
            System.out.println("Gelar: ");
            String degree = scanner.nextLine();
            System.out.println("Bidang Studi: ");
            String fieldOfStudy = scanner.nextLine();
            System.out.println("Tanggal Mulai (format: YYYY-MM-DD): ");
            String startDate = scanner.nextLine();
            System.out.println("Tanggal Selesai (format: YYYY-MM-DD): ");
            String endDate = scanner.nextLine();
    
            Pendidikan newPendidikan = new Pendidikan(school, degree, fieldOfStudy, startDate, endDate);
            resumeToEdit.getEducation().setPendidikan(newPendidikan);  // Update pendidikan
    
            // Edit Skill
            System.out.println("Masukkan informasi skill baru:");
            System.out.println("Nama Skill: ");
            String skillName = scanner.nextLine();
            System.out.println("Tingkatan Level (misal: Beginner, Intermediate, Expert): ");
            String level = scanner.nextLine();
    
            Skill newSkill = new Skill(skillName, level);
            resumeToEdit.getSkillDetail().setSkill(newSkill);  // Update skill
    
            // Edit Pengalaman
            System.out.println("Masukkan informasi pengalaman baru:");
            System.out.println("Posisi: ");
            String position = scanner.nextLine();
            System.out.println("Perusahaan: ");
            String company = scanner.nextLine();
            System.out.println("Tanggal Mulai (format: YYYY-MM-DD): ");
            String startExp = scanner.nextLine();
            System.out.println("Tanggal Selesai (format: YYYY-MM-DD): ");
            String endExp = scanner.nextLine();
            System.out.println("Deskripsi Pekerjaan: ");
            String description = scanner.nextLine();
    
            Pengalaman newPengalaman = new Pengalaman(position, company, startExp, endExp, description);
            resumeToEdit.getPengalamanLengkap().setPengalaman(newPengalaman);  // Update pengalaman
    
            System.out.println("Resume berhasil diperbarui!");
        } else {
            System.out.println("Resume dengan ID " + idDokumen + " tidak ditemukan.");
        }
    }
    

    // Menghapus resume berdasarkan ID Dokumen
    public void deleteResume(int idDokumen) {
        boolean found = false;
    
        // Mencari dan menghapus resume berdasarkan ID
        for (int i = 0; i < daftarResume.size(); i++) {
            if (daftarResume.get(i).getIdDokumen() == idDokumen) {
                daftarResume.remove(i);
                found = true;
                // Setel flag true jika resume ditemukan dan dihapus
            }
        }
    
        // Setelah loop selesai, cek apakah resume ditemukan
        if (found) {
            System.out.println("Resume dengan ID " + idDokumen + " berhasil dihapus!");
        } else {
            System.out.println("Resume dengan ID tersebut tidak ditemukan!");
        }
    }
    

    // Menampilkan semua resume pelamar
    public void showResumes() {
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
