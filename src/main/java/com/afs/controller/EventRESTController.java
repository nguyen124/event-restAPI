package com.afs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afs.model.Event;
import com.afs.services.EventService;

@RestController
public class EventRESTController {

	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> getAll() {
		List<Event> events = eventService.getEvents();
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}

	@RequestMapping(value = "/events", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveEvent(@RequestBody Event event, BindingResult result) {
		eventService.saveOrUpdateEvent(event);
		if (result.hasErrors()) {
			System.out.println("Has error return newEvent");
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
	}

//	@RequestMapping(value = "/events/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Event> updateEvent(@PathVariable("id") Integer id, @RequestBody Event event) {
//		Event acc = eventService.updateEvent(id, event);
//		return new ResponseEntity<Event>(acc, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Boolean> deleteEvent(@PathVariable("id") Integer id) {
//		Boolean result = eventService.deleteEvent(id);
//		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
//	}

}
