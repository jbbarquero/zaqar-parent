package com.malsolo.zaqar.alert.generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malsolo.zaqar.alert.generator.domain.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {

}
