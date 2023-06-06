package com.ablator.dashboard.dao;

import com.ablator.dashboard.entities.ScalerMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScalerMetricsDao extends JpaRepository<ScalerMetric, Long> {
    List<ScalerMetric> findAllByTrialId(Long trialId);
}
