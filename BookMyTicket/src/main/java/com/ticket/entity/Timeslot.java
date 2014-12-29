package com.ticket.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIMESLOT database table.
 * 
 */
@Entity
@NamedQuery(name="Timeslot.findAll", query="SELECT t FROM Timeslot t")
public class Timeslot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="END_TIME")
	private String endTime;

	@Column(name="START_TIME")
	private String startTime;

	//bi-directional many-to-one association to ShowTiming
	@OneToMany(mappedBy="timeslot")
	private List<ShowTiming> showTimings;

	public Timeslot() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public List<ShowTiming> getShowTimings() {
		return this.showTimings;
	}

	public void setShowTimings(List<ShowTiming> showTimings) {
		this.showTimings = showTimings;
	}

	public ShowTiming addShowTiming(ShowTiming showTiming) {
		getShowTimings().add(showTiming);
		showTiming.setTimeslot(this);

		return showTiming;
	}

	public ShowTiming removeShowTiming(ShowTiming showTiming) {
		getShowTimings().remove(showTiming);
		showTiming.setTimeslot(null);

		return showTiming;
	}

}