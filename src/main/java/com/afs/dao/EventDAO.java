package com.afs.dao;

import java.util.List;

import com.afs.model.Event;

public interface EventDAO {
	public boolean saveOrUpdateEvent(Event Event);

	public List<Event> getEvents();

	public Event getEvent(Long EventNo);

	public Long deleteEvent(Long EventNo);

}
