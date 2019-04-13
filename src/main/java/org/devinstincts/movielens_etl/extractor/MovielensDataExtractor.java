package org.devinstincts.movielens_etl.extractor;

import java.util.Collection;

import org.devinstincts.movielens_etl.entities.Movie;
import org.devinstincts.movielens_etl.entities.User;

/**
 * <pre>
 * <b>Description : </b>
 * The data extractor for Movielens app. Typically extracts the movielens data and makes it available for the application to transform and load.
 * 
 * &#64;author devinstincts
 * </pre>
 */
public interface MovielensDataExtractor {

	/**
	 * <pre>
	 * <b>Description : </b>
	 * Extracts movie records.
	 * </pre>
	 */
	Collection<Movie> extractMovies() throws Exception;

	/**
	 * <pre>
	 * <b>Description : </b>
	 * Extracts user records.
	 * </pre>
	 */
	Collection<User> extractUsers() throws Exception;

}
