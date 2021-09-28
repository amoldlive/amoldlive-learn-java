package com.thread.high.helper.user;

import java.util.concurrent.Callable;

public class UserProcessor implements Callable<Integer> {

	private String record;
	private UserDao userDao;

	public UserProcessor(String record, UserDao userDao) {
		super();
		this.record = record;
		this.userDao = userDao;
	}

	@Override
	public Integer call() throws Exception {
		String[] tokens = record.split(",");
		User user = new User(Integer.valueOf(tokens[2]), tokens[1], tokens[0]);
		System.out.println(Thread.currentThread().getName() + " User : " + user);
		int row = userDao.save(user);

		return row;
	}

}
