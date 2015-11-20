package com.malsolo.zaqar.event.receiver.domain.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malsolo.zaqar.event.receiver.application.EventManager;
import com.malsolo.zaqar.event.receiver.domain.Event;

@RestController
@RequestMapping("/events")
public class EventController {

	private static final Logger LOG = LoggerFactory
			.getLogger(EventController.class);

	private final EventManager eventManager;

	@Autowired
	public EventController(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	@RequestMapping(method = POST)
	public Event create(@RequestBody @Valid Event event) {
		LOG.info("Create EVENT: {}", event);
		return this.eventManager.createEvent(event);
	}

	@RequestMapping(method = GET)
	public List<Event> events() {
		LOG.debug("Get all EVENTS");
		return this.eventManager.showAllEvents();
	}
}
