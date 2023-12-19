package com.app.myportfolio.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Skill {
    @Id
    String id;
    String skillName;

    public Skill() {}

    public Skill(String id, String skillName) {
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
