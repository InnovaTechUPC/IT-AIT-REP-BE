package com.assignit.coreservice.project.service;

import com.assignit.coreservice.project.beans.ProjectBean;
import com.assignit.coreservice.project.dao.ProjectDAO;
import com.assignit.coreservice.task.dao.TaskDAO;
import com.assignit.coreservice.project.model.Project;
import com.assignit.coreservice.shared.base.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Log4j2
@Service
public class ProjectService extends BaseService<Project, ProjectBean> {

    @Autowired
    private ProjectDAO projectRepository;

    @Autowired
    private TaskDAO taskDAO;

    @Override
    public ProjectBean toBean(Project model, Class<ProjectBean> modelClass) {
        ProjectBean bean = new ProjectBean();
        BeanUtils.copyProperties(model, bean);
        bean.setTotalMembers((long) taskDAO.findUsersByProjectId(model.getId()).size());
        return bean;
    }

    public List<ProjectBean> getAllProjects() {
        List<ProjectBean> list = new ArrayList<>();
        List<Project> projects =  projectRepository.findAll();

        for (Project project : projects) {
            list.add(toBean(project, ProjectBean.class));
        }

        return list;
    }

    public ProjectBean getById(Long projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        if(projectOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Project %s not found", projectId));
        }

        return toBean(projectOptional.get(), ProjectBean.class);
    }

    public void createProject(ProjectBean projectBean) {
        projectRepository.save(toModel(projectBean, Project.class));
    }

    public void updateProject(Long projectId, ProjectBean projectBean) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        if(projectOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Project %s not found", projectId));
        }

        projectRepository.save(toModel(projectBean, Project.class));
    }

    public void deleteProject(Long projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        if(projectOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Project %s not found", projectId));
        }

        projectRepository.delete(projectOptional.get());
    }
}
