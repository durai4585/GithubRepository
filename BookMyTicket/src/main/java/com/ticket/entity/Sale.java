package com.ticket.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SALES database table.
 * 
 */
@Entity
@Table(name="SALES")
@NamedQuery(name="Sale.findAll", query="SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private double amount;

/*	//bi-directional one-to-one association to ShowTiming
	@OneToOne
	@JoinColumn(name="ID")
	private ShowTiming showTiming;*/

	public Sale() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	/*public ShowTiming getShowTiming() {
		return this.showTiming;
	}

	public void setShowTiming(ShowTiming showTiming) {
		this.showTiming = showTiming;
	}*/

}