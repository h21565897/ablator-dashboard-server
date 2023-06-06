package com.ablator.dashboard.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "scalers_history")
public class ScalerMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scalerId;

    private Long trialId;


    private String scaler;
}
