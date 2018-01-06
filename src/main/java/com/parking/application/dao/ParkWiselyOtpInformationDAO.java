package com.parking.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.application.model.PwOtpInformation;

@Repository
public interface ParkWiselyOtpInformationDAO extends JpaRepository<PwOtpInformation, Integer> {
	List<PwOtpInformation> findByEmail(String email);
}
