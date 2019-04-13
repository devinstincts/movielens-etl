package org.devinstincts.movielens_etl.extractor;

import java.util.Collection;

import org.devinstincts.movielens_etl.dao.GenericDAO;
import org.devinstincts.movielens_etl.entities.Movie;
import org.devinstincts.movielens_etl.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * <b>Description : </b>
 * The implementation for Movielens data extractor.
 * 
 * Loads the data from MySQL 'movielens' database.
 * 
 * &#64;author devinstincts
 * </pre>
 */
@Component
public class MovielensDataExtractorImpl implements MovielensDataExtractor {

	@Autowired
	private GenericDAO genericDAO;

	@Override
	public Collection<Movie> extractMovies() throws Exception {
		return genericDAO.findAll(Movie.class);
	}

	@Override
	public Collection<User> extractUsers() throws Exception {
		return genericDAO.findAll(User.class);
	}

}
