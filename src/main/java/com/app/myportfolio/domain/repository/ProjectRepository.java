package com.app.myportfolio.domain.repository;

import com.app.myportfolio.domain.entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, String> {
    List<Project> findByAccountId(String userId);
}
