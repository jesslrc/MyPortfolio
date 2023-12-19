package com.app.myportfolio.domain.service;

import com.app.myportfolio.api.dto.inbound.AddEducationDto;
import com.app.myportfolio.domain.entity.Education;
import com.app.myportfolio.domain.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    EducationRepository educationRepository;

    @Autowired
    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<Education> findByUserId(String userId) {
        return educationRepository.findByAccountId(userId);
    }

    public void saveEducation(AddEducationDto addEducationDto, String userId) {
        Education education = new Education(addEducationDto, userId);
        educationRepository.save(education);
    }
}
