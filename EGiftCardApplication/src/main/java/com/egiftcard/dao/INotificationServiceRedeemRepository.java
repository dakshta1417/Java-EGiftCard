package com.egiftcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.GiftRedeemDetails;

//Repository interface for NotificationServiceRedeem
@Repository
public interface INotificationServiceRedeemRepository extends JpaRepository<GiftRedeemDetails, Integer> {
}
