package com.ablator.dashboard;

import com.ablator.dashboard.api.ProjectInitializeTemplate;
import com.ablator.dashboard.api.UploadScalersTemplate;
import com.ablator.dashboard.controllers.ScalerMetricsController;
import com.ablator.dashboard.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DashboardApplicationTests {

    @Autowired
    ScalerMetricsController scalerMetricsController;

    @Autowired
    UserController userController;

    @Test
    void contextLoads() {
    }

    @Test
    public void testInitAndUpload() {
        Long userId = 1L;
        String projectName = "testproject";
        String trialName = "testTrial";
        List<String> scalers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            String jsonString = String.format("{\"step\":%d,\"_timestamp\":1685667137.1113617,\"metrics1\":%d}", i, i);
            scalers.add(jsonString);
        }
        userController.initProject(userId, ProjectInitializeTemplate.builder().projectName(projectName).build());
        UploadScalersTemplate uploadScalersTemplate = UploadScalersTemplate.builder()
                .scalers(scalers).projectName(projectName).trialName(trialName).build();
        scalerMetricsController.uploadScalers(userId, uploadScalersTemplate);
    }

}
