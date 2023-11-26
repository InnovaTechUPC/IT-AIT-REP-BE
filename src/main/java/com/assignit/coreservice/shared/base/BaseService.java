package com.assignit.coreservice.shared.base;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BaseService<T, Bean> {

    protected T toModel(Bean bean, Class<T> modelClass) {
        T model = createInstance(modelClass);
        BeanUtils.copyProperties(bean, model);
        return model;
    }

    protected Bean toBean(T model, Class<Bean> beanClass) {
        Bean bean = createInstance(beanClass);
        BeanUtils.copyProperties(model, bean);
        return bean;
    }

    private <U> U createInstance(Class<U> uClass) {
        try {
            return uClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Error al crear una nueva instancia", e);
        }
    }
}
