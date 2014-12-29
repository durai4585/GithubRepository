package com.ticket.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SHOW_TIMING database table.
 * 
 */
@Entity
@Table(name="SHOW_TIMING")
@NamedQuery(name="ShowTiming.findAll", query="SELECT s FROM ShowTiming s")
public class ShowTiming implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private int day;

/*	//bi-directional one-to-one association to Sale
	@OneToOne(mappedBy="showTiming")
	private Sale sale;*/

	//bi-directional many-to-one association to Movie
	@ManyToOne
	private Movie movie;

	//bi-directional many-to-one association to Theater
	@ManyToOne
	private Theater theater;

	//bi-directional many-to-one association to Timeslot
	@ManyToOne
	@JoinColumn(name="TIMING_ID")
	private Timeslot timeslot;

	public ShowTiming() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	/*public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
*/
	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theater getTheater() {
		return this.theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Timeslot getTimeslot() {
		return this.timeslot;
	}

	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}

}