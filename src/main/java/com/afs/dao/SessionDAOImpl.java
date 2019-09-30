package com.afs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.afs.entity.EventEntity;
import com.afs.entity.EventSessionEntity;
import com.afs.model.EventSession;

@Repository
public class SessionDAOImpl implements SessionDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveOrUpdateSession(EventSession eventSession, Long eventId) {
		boolean saveFlag = false;
		if (eventSession != null) {
			EventSessionEntity sessionEntity = new EventSessionEntity();
			sessionEntity.setName(eventSession.getName());
			sessionEntity.setPresenter(eventSession.getPresenter());
			sessionEntity.setLevel(eventSession.getLevel());
			sessionEntity.setDuration(eventSession.getDuration());
			sessionEntity.setAbstraction(eventSession.getAbstraction());

			EventEntity eventEntity = new EventEntity();
			eventEntity.setId(eventId);
			sessionEntity.setEvent(eventEntity);
			Session currentSession = sessionFactory.getCurrentSession();
			try {
				currentSession.saveOrUpdate(sessionEntity);
				saveFlag = true;
			} catch (Exception e) {
				currentSession.clear();
				e.printStackTrace();
			}
		}
		return saveFlag;
	}

	public List<EventSession> getSessions(Long eventId) {
		try {

			Session session = sessionFactory.getCurrentSession();
			Query<EventSessionEntity> sessionQuery = session.createQuery(
					"From EventSessionEntity ESE where ESE.event.id = " + eventId, EventSessionEntity.class);
			List<EventSessionEntity> eventSessionEntities = sessionQuery.getResultList();
			List<EventSession> eventSessions = new ArrayList<EventSession>();

			for (EventSessionEntity sessionEnt : eventSessionEntities) {
				EventSession eventSession = new EventSession();
				eventSession.setId(sessionEnt.getId());
				eventSession.setName(sessionEnt.getName());
				eventSession.setPresenter(sessionEnt.getPresenter());
				eventSession.setLevel(sessionEnt.getLevel());
				eventSession.setDuration(sessionEnt.getDuration());
				eventSession.setAbstraction(sessionEnt.getAbstraction());
				eventSessions.add(eventSession);
			}
			return eventSessions;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public EventSession getSession(Long sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteSession(Long sessionId) {
		// TODO Auto-generated method stub
		return false;
	}
}
