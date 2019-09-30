package com.afs.services;

import java.util.List;

import com.afs.model.EventSession;

public interface SessionService {
	public boolean saveOrUpdateSessionInAnEvent(EventSession session, Long eventId);

	public List<EventSession> getAllSessionsInAnEvent(Long eventId);

	public EventSession getEventSessionById(Long sessionNo);

	public int deleteEventSessionById(Long sessionNo);

	public List<EventSession> searchEventSessionByTerm(String term);
}
