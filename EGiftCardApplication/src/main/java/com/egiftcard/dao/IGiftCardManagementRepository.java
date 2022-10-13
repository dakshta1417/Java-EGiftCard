package com.egiftcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.GiftCard;

//Repository interface for GiftCardManagement
@Repository
public interface IGiftCardManagementRepository extends JpaRepository<GiftCard, Integer> {

}
