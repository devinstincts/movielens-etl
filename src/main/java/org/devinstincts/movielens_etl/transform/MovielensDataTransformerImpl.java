package org.devinstincts.movielens_etl.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.devinstincts.movielens_etl.document.MovieDocument;
import org.devinstincts.movielens_etl.document.RatingDocument;
import org.devinstincts.movielens_etl.document.UserDocument;
import org.devinstincts.movielens_etl.entities.Movie;
import org.devinstincts.movielens_etl.entities.MovieGenre;
import org.devinstincts.movielens_etl.entities.Rating;
import org.devinstincts.movielens_etl.entities.User;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * <b>Description : </b>
 * The data transformer implementation for the Movielens data set. Typically, it transforms MySQL records to MongoDB documents.
 * 
 * &#64;author $Author: devinstincts $
 * </pre>
 */
@Component
public class MovielensDataTransformerImpl implements MovielensDataTransformer {

	@Override
	public Collection<MovieDocument> transformMovieRecords(Collection<Movie> movies) {
		if (movies != null && !movies.isEmpty()) {
			List<MovieDocument> movieDocuments = new ArrayList<MovieDocument>();
			movies.forEach(movie -> {
				if (movie != null) {
					MovieDocument movieDocument = new MovieDocument();
					movieDocuments.add(movieDocument);
					movieDocument.setId(movie.getId());
					movieDocument.setTitle(movie.getTitle());
					movieDocument.setReleaseDate(movie.getReleaseDate());
					movieDocument.setVideo(movie.getVideo());
					movieDocument.setImdbUrl(movie.getImdbUrl());
					movieDocument.setId(movie.getId());
					movieDocument.setId(movie.getId());
					movieDocument.setId(movie.getId());
					movieDocument.setId(movie.getId());
					movieDocument.setId(movie.getId());

					Collection<MovieGenre> movieGenres = movie.getMovieGenres();
					if (movieGenres != null && !movieGenres.isEmpty()) {
						String[] genres = new String[movieGenres.size()];
						movieDocument.setGenres(genres);
						int i = 0;
						for (MovieGenre movieGenre : movieGenres) {
							if (movieGenre != null) {
								genres[i++] = movieGenre.getId().getGenre().getGenre();
							}
						}
					}

					Collection<Rating> movieUserRatings = movie.getRatings();
					if (movieUserRatings != null && !movieUserRatings.isEmpty()) {
						List<RatingDocument> ratings = new ArrayList<RatingDocument>();
						movieDocument.setRatings(ratings);
						movieUserRatings.forEach(movieUserRating -> {
							if (movieUserRating != null) {
								RatingDocument ratingDoc = new RatingDocument();
								ratingDoc.setUser(movieUserRating.getId().getUser().getId());
								ratingDoc.setRating(movieUserRating.getRating());
								ratingDoc.setTimestamp(movieUserRating.getTimestamp());
								ratings.add(ratingDoc);
							}
						});
					}
				}
			});
			return movieDocuments;
		}
		return null;
	}

	@Override
	public Collection<UserDocument> transformUserRecords(Collection<User> users) {
		if (users != null && !users.isEmpty()) {
			List<UserDocument> userDocuments = new ArrayList<UserDocument>();
			users.forEach(user -> {
				if (user != null) {
					UserDocument userDocument = new UserDocument();
					userDocument.setId(user.getId());
					userDocument.setAge(user.getAge());
					userDocument.setGender(user.getGender());
					userDocument.setOccupation(user.getOccupation());
					userDocument.setZipCode(user.getZipCode());
					userDocuments.add(userDocument);
				}
			});
			return userDocuments;
		}
		return null;
	}

}
