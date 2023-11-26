package com.assignit.coreservice.notification.service;

import com.assignit.coreservice.notification.model.Notification;
import com.assignit.coreservice.notification.beans.NotificationBean;
import com.assignit.coreservice.notification.dao.NotificationDAO;
import com.assignit.coreservice.shared.base.BaseService;
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
public class NotificationService extends BaseService<Notification, NotificationBean> {

    @Autowired
    private NotificationDAO notificationRepository;

    @Override
    public NotificationBean toBean(Notification model, Class<NotificationBean> modelClass) {
        NotificationBean bean = new NotificationBean();
        BeanUtils.copyProperties(model, bean);
        bean.setUserId(model.getUser().getId());
        bean.setProjectId(model.getProject().getId());
        return bean;
    }

    public List<NotificationBean> getAllNotifications() {
        List<NotificationBean> list = new ArrayList<>();
        List<Notification> notifications =  notificationRepository.findAll();

        for (Notification notification : notifications) {
            list.add(toBean(notification, NotificationBean.class));
        }

        return list;
    }

    public NotificationBean getById(Long notificationId) {
        Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);

        if(notificationOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Notification %s not found", notificationId));
        }

        return toBean(notificationOptional.get(), NotificationBean.class);
    }

    public void createNotification(NotificationBean notificationBean) {
        notificationRepository.save(toModel(notificationBean, Notification.class));
    }

    public void updateNotification(Long notificationId, NotificationBean notificationBean) {
        Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);

        if(notificationOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Notification %s not found", notificationId));
        }

        notificationRepository.save(toModel(notificationBean, Notification.class));
    }

    public void deleteNotification(Long notificationId) {
        Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);

        if(notificationOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Notification %s not found", notificationId));
        }

        notificationRepository.delete(notificationOptional.get());
    }
}
