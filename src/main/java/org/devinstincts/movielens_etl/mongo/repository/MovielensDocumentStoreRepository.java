package org.devinstincts.movielens_etl.mongo.repository;

import java.util.Collection;

import org.devinstincts.movielens_etl.document.MovieDocument;
import org.devinstincts.movielens_etl.document.UserDocument;

/**
 * <pre>
 * <b>Description : </b>
 * The repository for Movielens document store database.
 * 
 * @author $Author: devinstincts $ 
 * </pre>
 */
public interface MovielensDocumentStoreRepository {

    /**
     * <pre>
     * <b>Description : </b>
     * Saves all the movie documents given.
     * 
     * @param movies
     * @param drop, if true drops all the documents present and inserts the given documents.
     * </pre>
     */
    public void saveMovies(Collection<MovieDocument> movies, boolean drop);

    /**
     * <pre>
     * <b>Description : </b>
     * Saves all the user documents given.
     * 
     * @param users
     * @param drop, if true drops all the documents present and inserts the given documents.
     * </pre>
     */
    public void saveUsers(Collection<UserDocument> users, boolean drop);

}
