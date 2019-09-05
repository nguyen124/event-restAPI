package com.afs.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.afs.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final AtomicLong counter = new AtomicLong();
	private static List<User> users;

	static {
		users = populateDummyUsers();
	}

	private static List<User> populateDummyUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(new Long(counter.incrementAndGet()), "Sam", 123, new Date("01/01/1988"), "PSCode"));
		users.add(new User(new Long(counter.incrementAndGet()), "Sam", 123, new Date("01/02/1988"), "PSCode"));
		return users;
	}

	public User findById(long id) {
		for (User user : users) {
			if (user.getAccountNo() == id) {
				return user;
			}
		}
		return null;
	}

	public User findByName(String name) {
		for (User user : users) {
			if (user.getAccountHolderName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	public void saveUser(User user) {
		user.setAccountNo(new Long(counter.incrementAndGet()));
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			if (user.getAccountNo() == id) {
				iterator.remove();
			}
		}
	}

	public List<User> findAllUsers() {
		return users;
	}

	public void deleteAllUsers() {
		users.clear();
	}

	public boolean isUserExist(User user) {
		return findByName(user.getAccountHolderName()) != null;
	}

}
