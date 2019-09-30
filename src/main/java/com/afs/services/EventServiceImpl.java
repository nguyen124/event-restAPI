package com.afs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afs.dao.EventDAO;
import com.afs.model.Event;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventDAO eventDAO;

	@Transactional
	public boolean saveOrUpdateEvent(Event event) {
		eventDAO.saveOrUpdateEvent(event);
		return false;
	}

	@Transactional
	public List<Event> getEvents() {
		return eventDAO.getEvents();
	}

	@Transactional
	public Event getEvent(Long eventNo) {
		return eventDAO.getEvent(eventNo);
	}

	@Transactional
	public int deleteEvent(Long eventNo) {
		return eventDAO.deleteEvent(eventNo);
	}

}
