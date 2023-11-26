package com.assignit.coreservice.ai.service;

import com.assignit.coreservice.ai.beans.AiRestRequest;
import com.assignit.coreservice.ai.beans.AiRestResponse;
import com.assignit.coreservice.ai.model.Ai;
import com.assignit.coreservice.ai.beans.AiBean;
import com.assignit.coreservice.ai.dao.AiDAO;
import com.assignit.coreservice.ai.restservice.AiServiceRestClient;
import com.assignit.coreservice.shared.base.BaseService;
import com.assignit.coreservice.user.beans.UserBean;
import com.assignit.coreservice.user.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
public class AiService extends BaseService<Ai, AiBean> {

    @Autowired
    private AiDAO aiRepository;

    @Autowired
    private AiServiceRestClient aiServiceRestClient;


    @Override
    public AiBean toBean(Ai model, Class<AiBean> modelClass) {
        AiBean bean = new AiBean();
        BeanUtils.copyProperties(model, bean);
        bean.setUserId(model.getUser().getId());
        return bean;
    }

    public AiRestResponse aiChatService(AiRestRequest aiRestRequest) {
        return aiServiceRestClient.aiChatService(aiRestRequest);
    }

    public List<AiBean> getAllAis() {
        List<AiBean> list = new ArrayList<>();
        List<Ai> ais =  aiRepository.findAll();

        for (Ai ai : ais) {
            list.add(toBean(ai, AiBean.class));
        }

        return list;
    }

    public AiBean getById(Long aiId) {
        Optional<Ai> aiOptional = aiRepository.findById(aiId);

        if(aiOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Ai %s not found", aiId));
        }

        return toBean(aiOptional.get(), AiBean.class);
    }

    public void createAi(AiBean aiBean) {
        aiRepository.save(toModel(aiBean, Ai.class));
    }

    public void updateAi(Long aiId, AiBean aiBean) {
        Optional<Ai> aiOptional = aiRepository.findById(aiId);

        if(aiOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Ai %s not found", aiId));
        }

        aiRepository.save(toModel(aiBean, Ai.class));
    }

    public void deleteAi(Long aiId) {
        Optional<Ai> aiOptional = aiRepository.findById(aiId);

        if(aiOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Ai %s not found", aiId));
        }

        aiRepository.delete(aiOptional.get());
    }
}