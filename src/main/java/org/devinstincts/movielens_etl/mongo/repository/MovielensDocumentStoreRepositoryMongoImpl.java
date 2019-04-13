package org.devinstincts.movielens_etl.mongo.repository;

import java.util.Collection;

import org.devinstincts.movielens_etl.document.MovieDocument;
import org.devinstincts.movielens_etl.document.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * <b>Description : </b>
 * The MongoDB document store repository implementation for 'movielens' database.
 * 
 * @author $Author: devinstincts $ 
 * </pre>
 */
@Repository
public class MovielensDocumentStoreRepositoryMongoImpl implements MovielensDocumentStoreRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void saveMovies(Collection<MovieDocument> movies, boolean drop) {
        if (drop) {
            mongoTemplate.dropCollection(MovieDocument.class);
        }
        mongoTemplate.insertAll(movies);
    }

    public void saveUsers(Collection<UserDocument> users, boolean drop) {
        if (drop) {
            mongoTemplate.dropCollection(UserDocument.class);
        }
        mongoTemplate.insertAll(users);
    }
}
