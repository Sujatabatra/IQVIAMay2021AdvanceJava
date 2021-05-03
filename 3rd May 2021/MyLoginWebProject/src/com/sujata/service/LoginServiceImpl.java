package com.sujata.service;

import com.sujata.bean.User;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean loginCheck(User user) {
		return user.getUserName().equals(user.getPassword());
	}

}
