package com.main;

public class Skill {
    private String skillName;
    private String tingkatanLevel;

    public Skill(String skillName, String tingkatanLevel) {
        this.skillName = skillName;
        this.tingkatanLevel = tingkatanLevel;
    }

    public String getSkillDetail() {
        return skillName + " (" + tingkatanLevel + ")";
    }
}
