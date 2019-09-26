package com.afs.services;

import java.util.List;

import com.afs.model.Event;

public interface EventService {
	public boolean saveEvent(Event Event);

	public List<Event> getEvents();

	public Event getEvent(Integer EventNo);

	public boolean deleteEvent(int EventNo);
	
	public Event updateEvent(int id, Event Event);
}
