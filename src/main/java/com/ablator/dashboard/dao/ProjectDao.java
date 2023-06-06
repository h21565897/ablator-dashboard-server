package com.ablator.dashboard.dao;

import com.ablator.dashboard.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDao extends JpaRepository<Project, Long> {
    Project findByUserIdAndProjectName(Long userId, String projectName);

    List<Project> findAllByUserId(Long userId);
}
