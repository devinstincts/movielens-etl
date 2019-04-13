package org.devinstincts.movielens_etl.transform;

import java.util.Collection;

import org.devinstincts.movielens_etl.document.MovieDocument;
import org.devinstincts.movielens_etl.document.UserDocument;
import org.devinstincts.movielens_etl.entities.Movie;
import org.devinstincts.movielens_etl.entities.User;

/**
 * <pre>
 * <b>Description : </b>
 * The data transformer for the Movielens data set.
 * 
 * &#64;author $Author: devinstincts $
 * </pre>
 */
public interface MovielensDataTransformer {

	/**
	 * <pre>
	 * <b>Description : </b>
	 * Transforms movie records to movie documents.
	 * </pre>
	 */
	Collection<MovieDocument> transformMovieRecords(Collection<Movie> movies);

	/**
	 * <pre>
	 * <b>Description : </b>
	 * Transforms user records to user documents.
	 * </pre>
	 */
	Collection<UserDocument> transformUserRecords(Collection<User> users);
}
