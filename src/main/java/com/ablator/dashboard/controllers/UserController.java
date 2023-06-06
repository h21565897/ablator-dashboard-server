package com.ablator.dashboard.controllers;


import com.ablator.dashboard.api.ProjectInitializeTemplate;
import com.ablator.dashboard.dao.ProjectDao;
import com.ablator.dashboard.entities.Project;
import com.ablator.dashboard.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    ProjectDao projectDao;

    @PostMapping("/initProject")
    public ResponseVo initProject(@RequestHeader("Authenrication") Long userId, ProjectInitializeTemplate projectInitializeTemplate) {
        if (projectDao.findByUserIdAndProjectName(userId, projectInitializeTemplate.getProjectName()) == null) {
            projectDao.save(Project.builder().userId(userId).projectName(projectInitializeTemplate.getProjectName()).build());
        }

        return ResponseVo.success();
    }

    @GetMapping("/projects")
    public ResponseVo getAllProjects(@RequestHeader("Authentication") Long userId) {
        List<Project> projectList = projectDao.findAllByUserId(userId);
        return ResponseVo.success(projectList);
    }

    @GetMapping("/trials")
    public ResponseVo getAllTrials(Long projectId) {

    }
}
