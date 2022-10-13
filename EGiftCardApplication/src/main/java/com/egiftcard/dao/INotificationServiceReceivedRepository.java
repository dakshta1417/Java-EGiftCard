package com.egiftcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.GiftReceivedDetails;

//Repository interface for NotificationServiceReceived
@Repository
public interface INotificationServiceReceivedRepository extends JpaRepository<GiftReceivedDetails, Integer> {

}
