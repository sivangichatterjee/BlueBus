package com.nrifintech.bms.service;

import com.nrifintech.bms.entity.Admin;
import com.nrifintech.bms.request.UserLoginRequest;

/**
 * @author	Debopam
 * @email	debpal07@gmail.com
 * @created	Nov 9, 2021
 */
public interface UserService extends AbstractBaseService<Admin, Long> {
	public boolean isValidUser(UserLoginRequest userLoginRequest);
}
