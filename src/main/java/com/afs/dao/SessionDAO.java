package com.afs.dao;

import java.util.List;

import com.afs.model.Event;
import com.afs.model.EventSession;

public interface SessionDAO {
	public boolean saveOrUpdateSession(EventSession Session, Long eventId);

	public List<EventSession> getSessions(Long eventId);

	public EventSession getSession(Long sessionId);

	public boolean deleteSession(Long sessionId);
}
