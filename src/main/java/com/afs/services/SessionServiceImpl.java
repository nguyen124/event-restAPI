package com.afs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afs.dao.SessionDAO;
import com.afs.model.EventSession;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {
	@Autowired
	SessionDAO eventSessionDAO;

	public boolean saveOrUpdateSessionInAnEvent(EventSession eventSession, Long eventId) {
		return eventSessionDAO.saveOrUpdateSessionInAnEvent(eventSession, eventId);
	}

	public List<EventSession> getAllSessionsInAnEvent(Long eventId) {
		return eventSessionDAO.getAllSessionsInAnEvent(eventId);
	}

	public EventSession getEventSessionById(Long eventSessionId) {
		return eventSessionDAO.getEventSessionById(eventSessionId);
	}

	public int deleteEventSessionById(Long eventSessionId) {
		return eventSessionDAO.deleteEventSessionById(eventSessionId);
	}

	public List<EventSession> searchEventSessionByTerm(String term) {
		return eventSessionDAO.searchEventSessionByTerm(term);
	}

}
