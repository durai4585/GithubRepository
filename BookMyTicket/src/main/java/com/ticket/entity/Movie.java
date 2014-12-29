package com.ticket.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MOVIE database table.
 * 
 */
@Entity
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String actors;

	private String name;

	//bi-directional many-to-one association to ShowTiming
	@OneToMany(mappedBy="movie")
	private List<ShowTiming> showTimings;

	public Movie() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ShowTiming> getShowTimings() {
		return this.showTimings;
	}

	public void setShowTimings(List<ShowTiming> showTimings) {
		this.showTimings = showTimings;
	}

	public ShowTiming addShowTiming(ShowTiming showTiming) {
		getShowTimings().add(showTiming);
		showTiming.setMovie(this);

		return showTiming;
	}

	public ShowTiming removeShowTiming(ShowTiming showTiming) {
		getShowTimings().remove(showTiming);
		showTiming.setMovie(null);

		return showTiming;
	}

}