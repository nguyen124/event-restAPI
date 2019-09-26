package com.afs.model;

import java.util.Date;
import java.util.List;
import com.afs.model.EventSession;

public class Event {

	private Long id;
	private String name;
	private Date date;
	private String time;
	private Float price;
	private String imageUrl;
	private String onlineUrl;
	private Location location;
	private List<EventSession> eventSessions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getOnlineUrl() {
		return onlineUrl;
	}

	public void setOnlineUrl(String onlineUrl) {
		this.onlineUrl = onlineUrl;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<EventSession> getEventSessions() {
		return eventSessions;
	}

	public void setEventSessions(List<EventSession> sessions) {
		this.eventSessions = sessions;
	}

}
