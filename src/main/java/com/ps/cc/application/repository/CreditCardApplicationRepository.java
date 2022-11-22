package com.ps.cc.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.cc.application.entity.CreditCardApp;

public interface CreditCardApplicationRepository extends JpaRepository<CreditCardApp, Integer> {

	List<CreditCardApp> findAll();

}
