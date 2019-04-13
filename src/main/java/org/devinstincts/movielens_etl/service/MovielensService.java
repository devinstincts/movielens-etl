package org.devinstincts.movielens_etl.service;

import java.util.Collection;

import org.devinstincts.movielens_etl.entities.Movie;
import org.devinstincts.movielens_etl.entities.User;

/**
 * <pre>
 * <b>Description : </b>
 * The service component for the movielens application.
 * 
 * @author $Author: devinstincts $ 
 * </pre>
 */
public interface MovielensService {

    /**
     * <pre>
	 * <b>Description : </b>
	 * Lists all movies present in the SQL database.
	 * 
	 * @return
	 * </pre>
     */
    public Collection<Movie> listAllMovies();

    /**
     * <pre>
     * <b>Description : </b>
     * Lists all users present in the SQL database.
     * 
     * @return
     * </pre>
     */
    public Collection<User> listAllUsers();

    /**
     * <pre>
     * <b>Description : </b>
     * Saves all movie documents to MongoDB.
     * 
     * @return
     * </pre>
     */
    public void saveMovieDocuments(Collection<Movie> movies);

    /**
     * <pre>
     * <b>Description : </b>
     * Saves all user documents to MongoDB.
     * 
     * @return
     * </pre>
     */
    public void saveUserDocuments(Collection<User> users);

}
