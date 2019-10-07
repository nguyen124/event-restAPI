package com.afs.dao;

import java.util.List;

import com.afs.model.EventSession;

public interface SessionDAO {
	public boolean saveOrUpdateSessionInAnEvent(EventSession eventSession, Long eventId);

	public List<EventSession> getAllSessionsInAnEvent(Long eventId);

	public Integer deleteEventSessionById(Long eventSessionId);

	public EventSession getEventSessionById(Long eventSessionId);

	public List<EventSession> searchEventSessionByTerm(String term);
}
