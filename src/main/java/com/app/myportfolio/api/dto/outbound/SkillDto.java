package com.app.myportfolio.api.dto.outbound;

import com.app.myportfolio.domain.entity.Skill;

public class SkillDto {
    String id;
    String skillName;

    public static SkillDto fromDomain(Skill skill) {
        return new SkillDto(
                skill.getId(),
                skill.getSkillName()
        );
    }

    public SkillDto () {}

    public SkillDto(String id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
