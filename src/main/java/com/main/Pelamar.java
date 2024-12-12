package com.main;

import java.util.ArrayList;
public class abstract Pelamar extends Pengguna{
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

    public void addPendidikan(Pendidikan pendidikan){
        this.resume.getPendidikanList().add(pendidikan);
    }

    public void addPengalaman(Pengalaman pengalaman) {
        this.resume.getPengalamanList().add(pengalaman);
    }
    public void createProfile(Pendidikan pendidikan){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan informasi pelamar:");
        System.out.print("NIK: ");
        this.NIK = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("No HP: ");
        this.noHP = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
        this.tglLahir = scanner.nextLine();
        System.out.print("ID Dokumen: ");
        this.idDokumen = scanner.nextInt();

        System.out.println("\nTambahkan informasi pendidikan:");
        System.out.print("Nama Sekolah: ");
        String school = scanner.next();
        System.out.print("Gelar: ");
        String degree = scanner.next();
        System.out.print("Bidang Studi: ");
        String fieldOfStudy = scanner.next();
        System.out.print("Tanggal Mulai: ");
        String startDate = scanner.next();
        System.out.print("Tanggal Selesai: ");
        String endDate = scanner.next();

        // Tambahkan pendidikan ke resume
        Pendidikan pendidikan = new Pendidikan(school, degree, fieldOfStudy, startDate, endDate);
        this.resume.getPendidikanList().add(pendidikan);

        System.out.println("\nTambahkan informasi pengalaman:");
        System.out.print("Posisi: ");
        String position = scanner.next();
        System.out.print("Perusahaan: ");
        String company = scanner.next();
        System.out.print("Tanggal Mulai: ");
        String startExpDate = scanner.next();
        System.out.print("Tanggal Selesai: ");
        String endExpDate = scanner.next();
        System.out.print("Deskripsi: ");
        scanner.nextLine(); // Consume newline
        String description = scanner.nextLine();

        // Tambahkan pengalaman ke resume
        Pengalaman pengalaman = new Pengalaman(position, company, startExpDate, endExpDate, description);
        this.resume.getPengalamanList().add(pengalaman);

        System.out.println("Profil berhasil dibuat!");
    }
    public void editProfile(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Edit Profil Pelamar:");
        System.out.println("1. Edit Informasi Pribadi");
        System.out.println("2. Edit Pendidikan");
        System.out.println("3. Edit Pengalaman");
        System.out.println("4. Edit Skill");
        System.out.print("Pilih opsi: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // Edit informasi pribadi
                System.out.print("Masukkan NIK baru: ");
                this.NIK = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan No HP baru: ");
                this.noHP = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan Tanggal Lahir baru (yyyy-mm-dd): ");
                this.tglLahir = scanner.nextLine();
                System.out.println("Informasi pribadi berhasil diperbarui.");
                break;

            case 2:
                // Edit pendidikan
                System.out.println("Pendidikan saat ini:");
                int i = 1;
                for (Pendidikan p : this.resume.getPendidikanList()) {
                    System.out.println(i + ". " + p);
                    i++;
                }
                System.out.print("Pilih pendidikan yang ingin diedit (nomor): ");
                int pendidikanIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consume newline

                if (pendidikanIndex >= 0 && pendidikanIndex < this.resume.getPendidikanList().size()) {
                    Pendidikan pendidikan = this.resume.getPendidikanList().get(pendidikanIndex);
                    System.out.print("Nama Sekolah baru: ");
                    pendidikan.setSchool(scanner.nextLine());
                    System.out.print("Gelar baru: ");
                    pendidikan.setDegree(scanner.nextLine());
                    System.out.print("Bidang Studi baru: ");
                    pendidikan.setFieldOfStudy(scanner.nextLine());
                    System.out.print("Tanggal Mulai baru: ");
                    pendidikan.setStartDate(scanner.nextLine());
                    System.out.print("Tanggal Selesai baru: ");
                    pendidikan.setEndDate(scanner.nextLine());
                    System.out.println("Pendidikan berhasil diperbarui.");
                } else {
                    System.out.println("Pendidikan tidak ditemukan.");
                }
                break;

            case 3:
                // Edit pengalaman
                System.out.println("Pengalaman saat ini:");
                i = 1;
                for (Pengalaman p : this.resume.getPengalamanList()) {
                    System.out.println(i + ". " + p);
                    i++;
                }
                System.out.print("Pilih pengalaman yang ingin diedit (nomor): ");
                int pengalamanIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consume newline

                if (pengalamanIndex >= 0 && pengalamanIndex < this.resume.getPengalamanList().size()) {
                    Pengalaman pengalaman = this.resume.getPengalamanList().get(pengalamanIndex);
                    System.out.print("Posisi baru: ");
                    pengalaman.setPosition(scanner.nextLine());
                    System.out.print("Perusahaan baru: ");
                    pengalaman.setCompany(scanner.nextLine());
                    System.out.print("Tanggal Mulai baru: ");
                    pengalaman.setStartDate(scanner.nextLine());
                    System.out.print("Tanggal Selesai baru: ");
                    pengalaman.setEndDate(scanner.nextLine());
                    System.out.print("Deskripsi baru: ");
                    pengalaman.setDescription(scanner.nextLine());
                    System.out.println("Pengalaman berhasil diperbarui.");
                } else {
                    System.out.println("Pengalaman tidak ditemukan.");
                }
                break;

            case 4:
                // Edit skill
                System.out.println("Skill saat ini:");
                i = 1;
                for (Skill s : this.resume.getSkillList()) {
                    System.out.println(i + ". " + s);
                    i++;
                }
                System.out.print("Pilih skill yang ingin diedit (nomor): ");
                int skillIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consume newline

                if (skillIndex >= 0 && skillIndex < this.resume.getSkillList().size()) {
                    Skill skill = this.resume.getSkillList().get(skillIndex);
                    System.out.print("Nama Skill baru: ");
                    skill.setSkillName(scanner.nextLine());
                    System.out.print("Level baru: ");
                    skill.setTingkatanLevel(scanner.nextLine());
                    System.out.println("Skill berhasil diperbarui.");
                } else {
                    System.out.println("Skill tidak ditemukan.");
                }
                break;

            default:
                System.out.println("Opsi tidak valid.");
        }
    }
    }
    
}


