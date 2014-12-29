package com.ticket.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the THEATER database table.
 * 
 */
@Entity
@NamedQuery(name="Theater.findAll", query="SELECT t FROM Theater t")
public class Theater implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int capacity;

	//bi-directional many-to-one association to ShowTiming
	@OneToMany(mappedBy="theater")
	private List<ShowTiming> showTimings;

	public Theater() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<ShowTiming> getShowTimings() {
		return this.showTimings;
	}

	public void setShowTimings(List<ShowTiming> showTimings) {
		this.showTimings = showTimings;
	}

	public ShowTiming addShowTiming(ShowTiming showTiming) {
		getShowTimings().add(showTiming);
		showTiming.setTheater(this);

		return showTiming;
	}

	public ShowTiming removeShowTiming(ShowTiming showTiming) {
		getShowTimings().remove(showTiming);
		showTiming.setTheater(null);

		return showTiming;
	}

}