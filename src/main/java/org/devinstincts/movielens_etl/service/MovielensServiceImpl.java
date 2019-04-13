package org.devinstincts.movielens_etl.service;

import java.util.Collection;

import org.devinstincts.movielens_etl.document.MovieDocument;
import org.devinstincts.movielens_etl.document.UserDocument;
import org.devinstincts.movielens_etl.entities.Movie;
import org.devinstincts.movielens_etl.entities.User;
import org.devinstincts.movielens_etl.extractor.MovielensDataExtractor;
import org.devinstincts.movielens_etl.loader.MovielensDataLoader;
import org.devinstincts.movielens_etl.transform.MovielensDataTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * <b>Description : </b>
 * The service component implementation for the Movielens application.
 * 
 * &#64;author devinstincts
 * </pre>
 */
@Service
public class MovielensServiceImpl implements MovielensService {

	/**
	 * Data extractor.
	 */
	@Autowired
	private MovielensDataExtractor movielensDataExtractor;

	/**
	 * Data transformer.
	 */
	@Autowired
	private MovielensDataTransformer movielensDataTransformer;

	/**
	 * Data loader.
	 */
	@Autowired
	private MovielensDataLoader movielensDataLoader;

	public Collection<Movie> listAllMovies() {
		try {
			return movielensDataExtractor.extractMovies();
		} catch (Exception e) {
			// TODO exception handling
			e.printStackTrace();
			return null;
		}
	}

	public Collection<User> listAllUsers() {
		try {
			return movielensDataExtractor.extractUsers();
		} catch (Exception e) {
			// TODO exception handling
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void saveMovieDocuments(Collection<Movie> movies) {
		Collection<MovieDocument> movieDocuments = movielensDataTransformer.transformMovieRecords(movies);
		if (movieDocuments != null && !movieDocuments.isEmpty()) {
			// Drops movies collection if exists and then save the given documents
			try {
				movielensDataLoader.loadMovies(movieDocuments, true);
			} catch (Exception e) {
				// TODO exception handling
				e.printStackTrace();
			}
		}
	}

	@Override
	public void saveUserDocuments(Collection<User> users) {
		Collection<UserDocument> userDocuments = movielensDataTransformer.transformUserRecords(users);
		if (userDocuments != null && !userDocuments.isEmpty()) {
			try {
				movielensDataLoader.loadUsers(userDocuments, true);
			} catch (Exception e) {
				// TODO exception handling
				e.printStackTrace();
			}
		}
	}

}
