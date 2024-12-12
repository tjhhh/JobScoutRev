package com.main;

public class Resume {
    private int idDokumen;
    private Skill skill;
    private Pendidikan pendidikan;
    private Pengalaman pengalaman;

    public Resume(int idDokumen, Skill skill, Pendidikan pendidikan, Pengalaman pengalaman) {
        this.idDokumen = idDokumen;
        this.skill = skill;
        this.pendidikan = pendidikan;
        this.pengalaman = pengalaman;
    }

    public int getIdDokumen() {
        return idDokumen;
    }

    public void membuatResume() {
        System.out.println("\n=== Resume ===");
        System.out.println("ID Dokumen: " + idDokumen);
        System.out.println("Pendidikan: " + pendidikan.getEducation());
        System.out.println("Skill: " + skill.getSkillDetail());
        System.out.println("Pengalaman: " + pengalaman.getPengalamanLengkap());

    }
}
