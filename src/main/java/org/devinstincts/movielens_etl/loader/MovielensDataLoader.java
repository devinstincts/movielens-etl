package org.devinstincts.movielens_etl.loader;

import java.util.Collection;

import org.devinstincts.movielens_etl.document.MovieDocument;
import org.devinstincts.movielens_etl.document.UserDocument;

/**
 * <pre>
 * <b>Description : </b>
 * The data extractor for Movielens app. Typically loads the MongoDB with movie and user documents from the transformer.
 * 
 * &#64;author devinstincts
 * </pre>
 */
public interface MovielensDataLoader {

	/**
	 * <pre>
	 * <b>Description : </b>
	 * Dumps movie documents into MongoDB.
	 * </pre>
	 */
	void loadMovies(Collection<MovieDocument> movieDocuments, boolean dropCollection) throws Exception;

	/**
	 * <pre>
	 * <b>Description : </b>
	 * Dumps user documents into MongoDB.
	 * </pre>
	 */
	void loadUsers(Collection<UserDocument> userDocuments, boolean dropCollection) throws Exception;

}
