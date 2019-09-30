package com.afs.services;

import java.util.List;

import com.afs.model.Event;

public interface EventService {
	public boolean saveOrUpdateEvent(Event event);

	public List<Event> getEvents();

	public Event getEvent(Long eventNo);

	public int deleteEvent(Long eventNo);
}
