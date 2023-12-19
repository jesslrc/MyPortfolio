package com.app.myportfolio.api.dto.outbound;

import com.app.myportfolio.domain.entity.Education;

public class EducationDto {
    String id;
    String courseName;
    String institution;
    String educationLevel;

    public EducationDto(String id, String courseName, String institution, String educationLevel) {
        this.id = id;
        this.courseName = courseName;
        this.institution = institution;
        this.educationLevel = educationLevel;
    }

    public static EducationDto fromDomain(Education education) {
        return new EducationDto(
                education.getId(),
                education.getCourseName(),
                education.getInstitution(),
                education.getEducationLevel().name());
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

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }
}

