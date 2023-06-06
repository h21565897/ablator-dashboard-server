package com.ablator.dashboard.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadScalersTemplate {
    /**
     * name of the project
     */
    private String projectName;
    /**
     * upload scalers
     */
    private List<String> scalers;
    /**
     * current trailId
     */
    private String trialName;

}
