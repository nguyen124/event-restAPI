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

	public boolean saveOrUpdateSession(EventSession session, Long eventId) {

		return eventSessionDAO.saveOrUpdateSession(session, eventId);
	}

	public List<EventSession> getSessions(Long eventId) {
		return eventSessionDAO.getSessions(eventId);
	}

	public EventSession getSession(Long SessionNo) {
		return null;
	}

	public boolean deleteSession(Long SessionNo) {
		return false;
	}

}
