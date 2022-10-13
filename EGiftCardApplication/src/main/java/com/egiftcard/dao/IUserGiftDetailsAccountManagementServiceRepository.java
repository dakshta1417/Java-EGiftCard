package com.egiftcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.UserGiftDetails;

//Repository Interface for UserGiftDetailsAccountManagementService
@Repository
public interface IUserGiftDetailsAccountManagementServiceRepository extends JpaRepository<UserGiftDetails, Integer> {

}
