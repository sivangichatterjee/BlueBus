package com.nrifintech.bms.repository;

import org.springframework.stereotype.Repository;

import com.nrifintech.bms.entity.Admin;

/**
 * @author	Debopam
 * @email	debpal07@gmail.com
 * @created	Nov 9, 2021
 */
@Repository
public interface UserRepository extends AbstractBaseRepository<Admin, Long> {
	Admin findByUsername(String username);
}
