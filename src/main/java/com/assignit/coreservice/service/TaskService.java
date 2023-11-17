package com.assignit.coreservice.service;

import com.assignit.coreservice.beans.TaskBean;
import com.assignit.coreservice.dao.TaskDAO;
import com.assignit.coreservice.model.Task;
import com.assignit.coreservice.service.base.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j2
@Service
public class TaskService extends BaseService<Task, TaskBean> {

    @Autowired
    private TaskDAO taskRepository;

    @Override
    public TaskBean toBean(Task model, Class<TaskBean> modelClass) {
        TaskBean bean = new TaskBean();
        BeanUtils.copyProperties(model, bean);
        bean.setIdUser(model.getUser().getId());
        bean.setIdProject(model.getProject().getId());
        bean.setCompleted(Objects.equals(model.getHoursProgress(), model.getHoursTotal()));
        return bean;
    }

    public List<TaskBean> getAllTasks() {
        List<TaskBean> list = new ArrayList<>();
        List<Task> tasks =  taskRepository.findAll();

        for (Task task : tasks) {
            list.add(toBean(task, TaskBean.class));
        }

        return list;
    }

    public TaskBean getById(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if(taskOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Task %s not found", taskId));
        }

        return toBean(taskOptional.get(), TaskBean.class);
    }

    public List<TaskBean> getTasksByIdProject(Long idProject) {
        List<TaskBean> list = new ArrayList<>();
        List<Task> tasks = taskRepository.findTasksByProjectId(idProject);

        for (Task task : tasks) {
            list.add(toBean(task, TaskBean.class));
        }

        return list;
    }

    public void createTask(TaskBean taskBean) {
        taskRepository.save(toModel(taskBean, Task.class));
    }

    public void updateTask(Long taskId, TaskBean taskBean) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if(taskOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Task %s not found", taskId));
        }

        taskRepository.save(toModel(taskBean, Task.class));
    }

    public void deleteTask(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if(taskOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Task %s not found", taskId));
        }

        taskRepository.delete(taskOptional.get());
    }
}
