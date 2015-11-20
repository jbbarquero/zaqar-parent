package com.malsolo.zaqar.event.receiver.domain.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malsolo.zaqar.event.receiver.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	public List<Event> findByIdType(Long idType);

	public List<Event> findByIdTypeAndRequestDate(Long idType, Date requestDate);
	
	//TODO: http://docs.spring.io/spring-data/jpa/docs/1.9.1.RELEASE/reference/html/#specifications
	
}
