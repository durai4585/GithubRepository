package com.ticket.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the POINTS database table.
 * 
 */
@Entity
@Table(name="POINTS")
@NamedQuery(name="Point.findAll", query="SELECT p FROM Point p")
public class Point implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int points;

	public Point() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}