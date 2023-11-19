package com.assignit.coreservice.service;

import com.assignit.coreservice.beans.FeatureBean;
import com.assignit.coreservice.dao.FeatureDAO;
import com.assignit.coreservice.model.Feature;
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
public class FeatureService extends BaseService<Feature, FeatureBean> {

    @Autowired
    private FeatureDAO featureRepository;

    public List<FeatureBean> getAllFeatures() {
        List<FeatureBean> list = new ArrayList<>();
        List<Feature> features =  featureRepository.findAll();

        for (Feature feature : features) {
            list.add(toBean(feature, FeatureBean.class));
        }

        return list;
    }

    public FeatureBean getById(Long featureId) {
        Optional<Feature> featureOptional = featureRepository.findById(featureId);

        if(featureOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Feature %s not found", featureId));
        }

        return toBean(featureOptional.get(), FeatureBean.class);
    }

    public void createFeature(FeatureBean featureBean) {
        featureRepository.save(toModel(featureBean, Feature.class));
    }

    public void updateFeature(Long featureId, FeatureBean featureBean) {
        Optional<Feature> featureOptional = featureRepository.findById(featureId);

        if(featureOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Feature %s not found", featureId));
        }

        featureRepository.save(toModel(featureBean, Feature.class));
    }

    public void deleteFeature(Long featureId) {
        Optional<Feature> featureOptional = featureRepository.findById(featureId);

        if(featureOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Feature %s not found", featureId));
        }

        featureRepository.delete(featureOptional.get());
    }
}
