package com.malsolo.zaqar.alert.generator.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malsolo.zaqar.alert.generator.application.AlertGenerator;
import com.malsolo.zaqar.alert.generator.domain.Alert;
import com.malsolo.zaqar.alert.generator.domain.Event;

@RestController
@RequestMapping("/alerts")
public class AlertController {

	private static final Logger LOG = LoggerFactory
			.getLogger(AlertController.class);

	private final AlertGenerator alertGenerator;
	
	@Autowired
	public AlertController(AlertGenerator generator) {
		this.alertGenerator = generator;
	}
	
	@RequestMapping(method = POST)
	public Alert process(@RequestBody @Valid Event event) {
		LOG.info("Create EVENT: {}", event);
		return this.alertGenerator.processEvent(event);
	}

	@RequestMapping(method = GET)
	public ResponseEntity<List<Alert>> alerts() {
		LOG.debug("Get all ALERTS");
		return new ResponseEntity<>(this.alertGenerator.showAllAlerts(), HttpStatus.OK);
	}

	@RequestMapping(method = GET, path = "/{id}/events")
	public ResponseEntity<List<Event>> eventsForAlert(@PathVariable("id") Long id) {
		LOG.debug("Get all ALERTS");
		Alert alert = this.alertGenerator.findAlert(id);
		if (alert == null) {
			return new ResponseEntity<List<Event>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new ArrayList<>(alert.getEvents()), HttpStatus.OK); 
	}
}
