package com.afs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.afs.model.EventSession;

@Repository
public class SessionDAOImpl implements SessionDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveSession(EventSession Session) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<EventSession> getSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	public EventSession getSession(Integer SessionNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteSession(int SessionNo) {
		// TODO Auto-generated method stub
		return false;
	}

	public EventSession updateSession(int id, EventSession Session) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
