package com.afs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.afs.entity.EventEntity;
import com.afs.entity.EventSessionEntity;
import com.afs.model.Event;
import com.afs.model.EventSession;

@Repository
public class SessionDAOImpl implements SessionDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveOrUpdateSessionInAnEvent(EventSession eventSession, Long eventId) {
		boolean saveFlag = false;
		if (eventSession != null) {
			EventSessionEntity eventSessionEntity = new EventSessionEntity();
			setEventSessionEntityInfo(eventId, eventSessionEntity, eventSession);
			Session currentSession = sessionFactory.getCurrentSession();
			try {
				currentSession.saveOrUpdate(eventSessionEntity);
				saveFlag = true;
			} catch (Exception e) {
				currentSession.clear();
				e.printStackTrace();
			}
		}
		return saveFlag;
	}

	private void setEventSessionEntityInfo(Long eventId, EventSessionEntity eventSessionEntity,
			EventSession eventSession) {
		eventSessionEntity.setName(eventSession.getName());
		eventSessionEntity.setPresenter(eventSession.getPresenter());
		eventSessionEntity.setLevel(eventSession.getLevel());
		eventSessionEntity.setDuration(eventSession.getDuration());
		eventSessionEntity.setAbstraction(eventSession.getAbstraction());

		EventEntity eventEntity = new EventEntity();
		eventEntity.setId(eventId);
		eventSessionEntity.setEvent(eventEntity);
	}

	public List<EventSession> getAllSessionsInAnEvent(Long eventId) {
		try {

			Session session = sessionFactory.getCurrentSession();
			Query<EventSessionEntity> sessionQuery = session.createQuery(
					"From EventSessionEntity ESE where ESE.event.id = " + eventId, EventSessionEntity.class);
			List<EventSessionEntity> eventSessionEntities = sessionQuery.getResultList();
			List<EventSession> eventSessions = new ArrayList<EventSession>();

			for (EventSessionEntity sessionEnt : eventSessionEntities) {
				EventSession eventSession = new EventSession();
				setEventSessionInfo(eventSession, sessionEnt);
				eventSessions.add(eventSession);
			}
			return eventSessions;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setEventSessionInfo(EventSession eventSession, EventSessionEntity sessionEnt) {
		eventSession.setId(sessionEnt.getId());
		eventSession.setName(sessionEnt.getName());
		eventSession.setPresenter(sessionEnt.getPresenter());
		eventSession.setLevel(sessionEnt.getLevel());
		eventSession.setDuration(sessionEnt.getDuration());
		eventSession.setAbstraction(sessionEnt.getAbstraction());
		eventSession.setEventId(sessionEnt.getEvent().getId());
		
	}

	public EventSession getEventSessionById(Long sessionId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<EventSessionEntity> eventSessionQuery = currentSession
				.createQuery("From EventSessionEntity ESE where ESE.id = " + sessionId, EventSessionEntity.class);
		EventSessionEntity sessionEnt = eventSessionQuery.getSingleResult();
		EventSession result = new EventSession();
		setEventSessionInfo(result, sessionEnt);
		return result;
	}

	public Integer deleteEventSessionById(Long sessionId) {
		Session currentSession = null;
		try {
			currentSession = sessionFactory.getCurrentSession();
			Query eventSessionQuery = currentSession
					.createQuery("Delete from EventSessionEntity ESE where ESE.id = :id");
			eventSessionQuery.setParameter("id", sessionId);
			return eventSessionQuery.executeUpdate();
		} catch (Exception e) {
			currentSession.clear();
			e.printStackTrace();
		}
		return 0;
	}

	public List<EventSession> searchEventSessionByTerm(String term) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<EventSessionEntity> eventSessionQuery = currentSession
				.createQuery("From EventSessionEntity ESE where ESE.name like :name", EventSessionEntity.class);
		eventSessionQuery.setParameter("name", term);
		List<EventSession> result = new ArrayList<EventSession>();
		for (EventSessionEntity eventSessionEnt : eventSessionQuery.getResultList()) {
			EventSession eventSession = new EventSession();
			setEventSessionInfo(eventSession, eventSessionEnt);
			result.add(eventSession);
		}
		return result;
	}
}
