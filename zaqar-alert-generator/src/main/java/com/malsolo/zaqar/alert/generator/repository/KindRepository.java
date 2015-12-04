package com.malsolo.zaqar.alert.generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malsolo.zaqar.alert.generator.domain.Kind;

public interface KindRepository extends JpaRepository<Kind, Long> {

}
