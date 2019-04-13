package org.devinstincts.movielens_etl.loader;

import java.util.Collection;

import org.devinstincts.movielens_etl.document.MovieDocument;
import org.devinstincts.movielens_etl.document.UserDocument;
import org.devinstincts.movielens_etl.mongo.repository.MovielensDocumentStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * <b>Description : </b>
 * Implementation for MovielensDataLoader to load the data into MongoDB.
 * 
 * &#64;author devinstincts
 * </pre>
 */
@Component
public class MovielensDataLoaderImpl implements MovielensDataLoader {

	@Autowired
	private MovielensDocumentStoreRepository movieDocumentRepository;

	@Override
	public void loadMovies(Collection<MovieDocument> movieDocuments, boolean dropCollection) throws Exception {
		movieDocumentRepository.saveMovies(movieDocuments, dropCollection);
	}

	@Override
	public void loadUsers(Collection<UserDocument> userDocuments, boolean dropCollection) throws Exception {
		movieDocumentRepository.saveUsers(userDocuments, dropCollection);
	}

}
