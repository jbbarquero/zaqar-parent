package com.malsolo.zaqar.alert.generator.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malsolo.zaqar.alert.generator.domain.Alert;
import com.malsolo.zaqar.alert.generator.domain.Event;
import com.malsolo.zaqar.alert.generator.domain.EventStatus;
import com.malsolo.zaqar.alert.generator.domain.Kind;
import com.malsolo.zaqar.alert.generator.repository.AlertRepository;
import com.malsolo.zaqar.alert.generator.repository.KindRepository;

@Service
public class AlertGenerator {

	private static final Logger LOG = LoggerFactory.getLogger(AlertGenerator.class);

	private final KindRepository kindRepository;
	private final AlertRepository alertRepository;
	private final EventService eventService;

	@Autowired
	public AlertGenerator(KindRepository kindRepository, AlertRepository alertRepository, 
			@Qualifier("eventServiceJustLog") EventService eventService) {
		this.kindRepository = kindRepository;
		this.alertRepository = alertRepository;
		this.eventService = eventService;
	}

	public Alert processEvent(Event event) {
		LOG.debug("Process Event {}", event);
		List<Event> events = new ArrayList<>();
		Integer status = null;

		Kind kind = this.kindRepository.findOne(event.getIdKind());
		LOG.debug("Searched kind of the event {}", kind);

		if (kind == null) {
			status = EventStatus.IGNORED.status();
		} else if (!kind.getActive()) {
			status = EventStatus.INACTIVE.status();
		} else if (kind.getAdditionalEvents() != 1) {
			DateTime now = new DateTime();
			events = eventService.getEventsBetweenDates(now.toDate(), now.minusMillis(kind.getAdditionalEventsTimeBefore().intValue()).toDate());
			status = EventStatus.MULTI_PROCESSED.status();
		} else {
			events = Arrays.asList(event);
			status = EventStatus.PROCESSED.status();
		}
		int eventsNumber = events.size();
		LOG.debug("Updated status for the event {} and found {} related events", status, eventsNumber);
		
		if (eventsNumber > 0) {
			for (Event event2update : events) {
				event2update.setStatus(status);
				this.eventService.update(event2update);
			}
		} else {
			event.setStatus(status);
			this.eventService.update(event);
		}
		LOG.debug("Updated Event {} (and {} more)", event, eventsNumber > 1 ? (eventsNumber -1) : eventsNumber);
		
		Alert alert = alertRepository.save(AlertFactory.getInstance(kind, events));
		LOG.debug("Created Alert {}", alert);

		return alert;
	}

	public List<Alert> showAllAlerts() {
		List<Alert> alerts = this.alertRepository.findAll();
		LOG.debug("Found {} Alerts", alerts.size());
		return alerts;
	}

	public Alert findAlert(Long id) {
		Alert alert = this.alertRepository.findOne(id);
		LOG.debug("Found {} Alert", (alert != null ? alert.toString() : "none"));
		return alert;
	}

}
