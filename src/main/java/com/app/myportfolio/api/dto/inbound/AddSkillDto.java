package com.app.myportfolio.api.dto.inbound;

public class AddSkillDto {
    String accountId;
    String skillId;

    public AddSkillDto(String accountId, String skillId) {
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
