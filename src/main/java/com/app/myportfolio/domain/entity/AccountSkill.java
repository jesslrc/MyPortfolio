package com.app.myportfolio.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class AccountSkill {

    @EmbeddedId
    private AccountSkillId id;

    public AccountSkill(String accountId, String skillId) {
        this.id = new AccountSkillId(accountId, skillId);
    }

    public AccountSkill() {}

    public AccountSkill(AccountSkillId id) {
        this.id = id;
    }

    public AccountSkillId getId() {
        return id;
    }

    public void setId(AccountSkillId id) {
        this.id = id;
    }

    @Embeddable
    public static class AccountSkillId implements Serializable {
        @Column(name = "account_id")
        private String accountId;

        @Column(name = "skill_id")
        private String skillId;

        public AccountSkillId() {
        }

        public AccountSkillId(String accountId, String skillId) {
            this.accountId = accountId;
            this.skillId = skillId;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getSkillId() {
            return skillId;
        }

        public void setSkillId(String skillId) {
            this.skillId = skillId;
        }
    }
}
