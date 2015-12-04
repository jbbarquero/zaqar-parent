package com.malsolo.zaqar.alert.generator.application;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import com.malsolo.zaqar.alert.generator.domain.Alert;
import com.malsolo.zaqar.alert.generator.domain.Event;
import com.malsolo.zaqar.alert.generator.domain.Kind;

public class AlertFactory {
	
	public static Alert getInstance(Kind kind, List<Event> events) {
		Alert alert = new Alert();
		alert.setKind(kind);
		alert.setEvents(new HashSet<>(events));
		alert.setCreationDate(new Date());
		alert.setMessage(transform(events.get(0).getData()));
		return alert;
	}

	private static String transform(String data) {
		return data;
	}

}
