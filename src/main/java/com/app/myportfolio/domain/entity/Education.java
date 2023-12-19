package com.app.myportfolio.domain.entity;

import com.app.myportfolio.api.dto.inbound.AddEducationDto;
import com.app.myportfolio.api.dto.outbound.EducationDto;
import com.app.myportfolio.domain.service.EducationService;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Education {

    @Id
    String id;
    String accountId;
    String courseName;
    String institution;

    @Enumerated(EnumType.STRING)
    EducationLevel educationLevel;

    public Education() {
    }

    public Education(AddEducationDto addEducationDto, String userId) {
        this.id = UUID.randomUUID().toString();
        this.accountId = userId;
        this.courseName = addEducationDto.getCourseName();
        this.institution = addEducationDto.getInstitution();
        this.educationLevel = EducationLevel.valueOf(addEducationDto.getEducationLevel());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
