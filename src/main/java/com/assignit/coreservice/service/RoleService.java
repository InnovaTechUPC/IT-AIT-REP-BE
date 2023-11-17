package com.assignit.coreservice.service;

import com.assignit.coreservice.beans.RoleBean;
import com.assignit.coreservice.dao.RoleDAO;
import com.assignit.coreservice.model.Role;
import com.assignit.coreservice.service.base.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
public class RoleService extends BaseService<Role, RoleBean> {

    @Autowired
    private RoleDAO roleRepository;

    public List<RoleBean> getAllRoles() {
        List<RoleBean> list = new ArrayList<>();
        List<Role> roles =  roleRepository.findAll();

        for (Role role : roles) {
            list.add(toBean(role, RoleBean.class));
        }

        return list;
    }

    public RoleBean getById(Long roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);

        if(roleOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Role %s not found", roleId));
        }

        return toBean(roleOptional.get(), RoleBean.class);
    }

    public void createRole(RoleBean roleBean) {
        roleRepository.save(toModel(roleBean, Role.class));
    }

    public void updateRole(Long roleId, RoleBean roleBean) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);

        if(roleOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Role %s not found", roleId));
        }

        roleRepository.save(toModel(roleBean, Role.class));
    }

    public void deleteRole(Long roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);

        if(roleOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Role %s not found", roleId));
        }

        roleRepository.delete(roleOptional.get());
    }
}
