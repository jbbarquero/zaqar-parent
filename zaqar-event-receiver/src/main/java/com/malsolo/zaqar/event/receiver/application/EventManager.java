package com.malsolo.zaqar.event.receiver.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malsolo.zaqar.event.receiver.domain.Event;
import com.malsolo.zaqar.event.receiver.domain.repository.EventRepository;

@Service
public class EventManager {

	private final EventRepository eventRepository;

	@Autowired
	public EventManager(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public Event createEvent(Event newEvent) {
		Event eventToSave = new Event(null, newEvent.getIdType(),
				newEvent.getCode(), newEvent.getData(),
				newEvent.getCreationDate(), new Date(), null, 0);
		return this.eventRepository.save(eventToSave);
	}

	public List<Event> showAllEvents() {
		return this.eventRepository.findAll();
	}

}
