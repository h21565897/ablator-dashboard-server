package com.ablator.dashboard.dao;

import com.ablator.dashboard.entities.Trial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrialsDao extends JpaRepository<Trial, Long> {
    Trial findByTrialNameAndProjectId(String trialName, Long projectId);


}
