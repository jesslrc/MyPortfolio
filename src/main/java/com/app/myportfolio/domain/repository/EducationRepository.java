package com.app.myportfolio.domain.repository;

import com.app.myportfolio.domain.entity.Education;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EducationRepository extends CrudRepository<Education, String> {
    List<Education> findByAccountId(String userId);

}
