package com.nrifintech.bms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class Ticket extends AbstractBaseEntity {
	private static final long serialVersionUID = 6715094082833854125L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pnr_seq")
	@SequenceGenerator(name = "pnr_seq", sequenceName="pnr_seq", allocationSize=1)
	@Column(name="PNR_NUMBER")
	private Long pnr;
	
	@Column(name="SEATS_BOOKED", nullable = false)
	private int seatsBooked;
	
	@Column(name="DATE_OF_DEPARTURE", nullable = false)
	private Date dateOfDept;
	
	@Column(name="EMAIL", nullable = false)
	private String email;
	
	@ManyToOne
	@JoinColumn(name="BUS_CODE", nullable = false)
	private Bus bus;
	
	@OneToOne
	@JoinColumn(name="START_STOP_CODE", nullable = false)
	public BusStop start;
	
	@OneToOne
	@JoinColumn(name="END_STOP_CODE", nullable = false)
	public BusStop stop;

	public Ticket() {
	}

	public Ticket(int seatsBooked, Date dateOfDept, String email, Bus bus, BusStop start, BusStop stop) {
		this.seatsBooked = seatsBooked;
		this.dateOfDept = dateOfDept;
		this.email = email;
		this.bus = bus;
		this.start = start;
		this.stop = stop;
	}

	public Long getPnr() {
		return pnr;
	}
	
	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public Date getDateOfDept() {
		return dateOfDept;
	}

	public void setDateOfDept(Date dateOfDept) {
		this.dateOfDept = dateOfDept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public BusStop getStart() {
		return start;
	}

	public void setStart(BusStop start) {
		this.start = start;
	}

	public BusStop getStop() {
		return stop;
	}

	public void setStop(BusStop stop) {
		this.stop = stop;
	}

}
