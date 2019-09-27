package com.afs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afs.model.EventSession;
import com.afs.services.SessionService;

@RestController
public class SessionRESTController {

	@Autowired
	private SessionService sessionService;

	@RequestMapping(value = "/events/{id}/sessions", method = RequestMethod.GET)
	public ResponseEntity<List<EventSession>> getAll(@PathVariable("id") Long eventId) {
		List<EventSession> list = sessionService.getSessions(eventId);
		return new ResponseEntity<List<EventSession>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "events/{id}/sessions", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveSession(@PathVariable("id") Long eventId, @RequestBody EventSession session,
			BindingResult result) {
		sessionService.saveOrUpdateSession(session, eventId);
		if (result.hasErrors()) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
	}
}
