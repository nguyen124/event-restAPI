package com.afs.services;

import java.util.List;

import com.afs.model.EventSession;

public interface SessionService {
	public boolean saveOrUpdateSession(EventSession session, Long eventId);

	public List<EventSession> getSessions(Long eventId);

	public EventSession getSession(Long sessionNo);

	public boolean deleteSession(Long sessionNo);
}
