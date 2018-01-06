package com.parking.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.application.model.PwUser;

@Repository
public interface ParkWiselyUserDAO extends JpaRepository<PwUser, Integer>{
	

}
