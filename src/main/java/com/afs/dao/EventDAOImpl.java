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
import com.afs.entity.LocationEntity;
import com.afs.model.Event;
import com.afs.model.EventSession;
import com.afs.model.Location;

@Repository
public class EventDAOImpl implements EventDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveOrUpdateEvent(Event event) {
		boolean saveFlag = false;
		if (event != null) {
			EventEntity eventEnt = new EventEntity();
			setEventEntityBasicInfo(eventEnt, event);
			setEventEntityLocation(eventEnt, event);
			try {
				Session currentSession = sessionFactory.getCurrentSession();
				currentSession.saveOrUpdate(eventEnt);
				saveFlag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return saveFlag;
	}

	private void setEventEntityBasicInfo(EventEntity eventEnt, Event event) {
		eventEnt.setId(event.getId());
		eventEnt.setName(event.getName());
		eventEnt.setDate(event.getDate());
		eventEnt.setPrice(event.getPrice());
		eventEnt.setTime(event.getTime());
		eventEnt.setImageUrl(event.getImageUrl());
		eventEnt.setOnlineUrl(event.getOnlineUrl());
	}

	private void setEventEntityLocation(EventEntity eventEnt, Event event) {
		LocationEntity locationEnt = new LocationEntity();
		if (event.getLocation() != null) {
			locationEnt.setId(event.getLocation().getId());
			locationEnt.setAddress(event.getLocation().getAddress());
			locationEnt.setCountry(event.getLocation().getCountry());
			locationEnt.setCity(event.getLocation().getCity());
			eventEnt.setLocation(locationEnt);
		}
	}

	public List<Event> getEvents() {
		List<Event> list = new ArrayList<Event>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<EventEntity> query = session.createQuery("From EventEntity", EventEntity.class);
			List<EventEntity> events = query.getResultList();

			for (EventEntity eventEnt : events) {
				Event ev = new Event();
				loadEvenInfo(ev, eventEnt, session);
				list.add(ev);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private void loadEvenInfo(Event ev, EventEntity eventEnt, Session session) {
		loadEventBasicInfo(ev, eventEnt);
		loadEventLocation(ev, eventEnt);
		loadEventSessions(ev, eventEnt, session);
	}

	private void loadEventBasicInfo(Event ev, EventEntity eventEnt) {
		ev.setId(eventEnt.getId());
		ev.setName(eventEnt.getName());
		ev.setDate(eventEnt.getDate());
		ev.setPrice(eventEnt.getPrice());
		ev.setTime(eventEnt.getTime());
		ev.setImageUrl(eventEnt.getImageUrl());
		ev.setOnlineUrl(eventEnt.getOnlineUrl());
	}

	private void loadEventLocation(Event ev, EventEntity eventEnt) {
		Location location = new Location();
		if (eventEnt.getLocation() != null) {
			location.setId(eventEnt.getLocation().getId());
			location.setAddress(eventEnt.getLocation().getAddress());
			location.setCountry(eventEnt.getLocation().getCountry());
			location.setCity(eventEnt.getLocation().getCity());
			ev.setLocation(location);
		}
	}

	private void loadEventSessions(Event ev, EventEntity eventEnt, Session session) {
		Query<EventSessionEntity> sessionQuery = session.createQuery(
				"From EventSessionEntity ES where ES.event.id = " + eventEnt.getId(), EventSessionEntity.class);
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
		;
		ev.setEventSessions(eventSessions);
	}

	public Event getEvent(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEvent(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
