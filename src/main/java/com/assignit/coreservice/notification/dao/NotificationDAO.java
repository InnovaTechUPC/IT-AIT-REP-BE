package com.assignit.coreservice.notification.dao;

import com.assignit.coreservice.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationDAO extends JpaRepository<Notification, Long> {

}
