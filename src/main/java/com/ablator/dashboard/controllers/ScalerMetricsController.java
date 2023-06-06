package com.ablator.dashboard.controllers;


import com.ablator.dashboard.api.UploadScalersTemplate;
import com.ablator.dashboard.dao.ProjectDao;
import com.ablator.dashboard.dao.ScalerMetricsDao;
import com.ablator.dashboard.dao.TrialsDao;
import com.ablator.dashboard.entities.Project;
import com.ablator.dashboard.entities.ScalerMetric;
import com.ablator.dashboard.entities.Trial;
import com.ablator.dashboard.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/files")
public class ScalerMetricsController {

    @Autowired
    TrialsDao trialsDao;

    @Autowired
    ScalerMetricsDao scalerMetricsDao;

    @Autowired
    ProjectDao projectDao;

    @PostMapping("/scalers")
    public ResponseVo uploadScalers(@RequestHeader("Authentication") Long userId, UploadScalersTemplate uploadScalersTemplate) {
        Project project = projectDao.findByUserIdAndProjectName(userId, uploadScalersTemplate.getProjectName());
        if (project == null) {
            return ResponseVo.fail("", "project does not exist, should be created first");
        }
        Trial trial = trialsDao.findByTrialNameAndProjectId(uploadScalersTemplate.getTrialName(), project.getProjectId());
        if (trial == null) {
            trial = trialsDao.save(Trial.builder().trialName(uploadScalersTemplate.getTrialName()).projectId(project.getProjectId()).build());
        }
        for (String scaler : uploadScalersTemplate.getScalers()) {
            scalerMetricsDao.save(ScalerMetric.builder().trialId(trial.getTrialId()).scaler(scaler).build());
        }
        return ResponseVo.success();
    }

    @GetMapping("/scalers/{trialId}")
    @ResponseBody
    public ResponseVo getMetrics(@PathVariable Long trialId) {
        List<ScalerMetric> scalers = scalerMetricsDao.findAllByTrialId(trialId);
        return ResponseVo.success(scalers);
    }


}
