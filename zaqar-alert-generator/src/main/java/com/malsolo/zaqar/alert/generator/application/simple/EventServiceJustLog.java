package com.malsolo.zaqar.alert.generator.application.simple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.malsolo.zaqar.alert.generator.application.EventService;
import com.malsolo.zaqar.alert.generator.domain.Event;

@Service
public class EventServiceJustLog implements EventService {

	private static final Logger LOG = LoggerFactory.getLogger(EventServiceJustLog.class);

	@Override
	public Event update(Event event) {
		LOG.debug("Update {}", event);
		event.setProcessDate(new Date());
		return event;
	}

	@Override
	public List<Event> getEventsBetweenDates(Date from, Date to) {
		LOG.debug("Events between {} and {}", from, to);
		return new ArrayList<>();
	}

}
