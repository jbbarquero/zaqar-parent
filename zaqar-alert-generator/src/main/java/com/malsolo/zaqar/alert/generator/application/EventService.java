package com.malsolo.zaqar.alert.generator.application;

import java.util.Date;
import java.util.List;

import com.malsolo.zaqar.alert.generator.domain.Event;

public interface EventService {
	
	public Event update(Event event);
	
	public List<Event> getEventsBetweenDates(Date from, Date to);
}
