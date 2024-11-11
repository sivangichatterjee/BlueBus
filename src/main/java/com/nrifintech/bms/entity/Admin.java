package com.nrifintech.bms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author	Debopam
 * @email	debpal07@gmail.com
 * @created	Nov 9, 2021
 */
@Entity
@Table(name="USER")
public class Admin extends AbstractBaseEntity {
	private static final long serialVersionUID = 6715094082833854125L;


	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)				//Developer note: Check if this fits your task, else replace
	 private Long id;
	

	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
