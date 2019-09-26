package com.afs.dao;

import java.util.List;

import com.afs.model.EventSession;

public interface SessionDAO {
	public boolean saveSession(EventSession Session);

	public List<EventSession> getSessions();

	public EventSession getSession(Integer SessionNo);

	public boolean deleteSession(int SessionNo);

	public EventSession updateSession(int id, EventSession Session);
}
