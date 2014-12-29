package com.ticket.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.ticket.entity.Movie;

/**
 * Session Bean implementation class TicketSession
 */
@Stateless
@Named
@Path("movie")
public class MovieFacadeREST extends AbstractFacade<Movie> {
	
	@PersistenceContext(unitName = "BookMyShowPU")
	EntityManager entityMgr;
	
	/**
	 * Default constructor.
	 */
	public MovieFacadeREST() {
		super(Movie.class);

	}

	@GET
	@Produces(value = { "applications/xml", "application/json" })
	public List<Movie> getMovies() {

		return findAll();

	}
	

	@GET
	@Path("counts")
	@Produces(value = { "text/plain" })
	public String movieCount() {

		return "5";

	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityMgr;
	}

}
