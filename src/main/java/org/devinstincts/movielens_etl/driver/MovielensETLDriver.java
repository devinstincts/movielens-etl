package org.devinstincts.movielens_etl.driver;

import org.devinstincts.movielens_etl.service.MovielensService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <pre>
 * <b>Description : </b>
 * The entry point of the Movielens ETL application. Run this class to load the data from MySQL, transform and load it to MongoDB database.
 * 
 * &#64;author devinstincts
 * </pre>
 */
public class MovielensETLDriver {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		final ApplicationContext context = new AnnotationConfigApplicationContext("org.devinstincts.movielens_etl");
		MovielensService movielensService = context.getBean(MovielensService.class);

		movielensService.saveMovieDocuments(movielensService.listAllMovies());
		movielensService.saveUserDocuments(movielensService.listAllUsers());
	}

}
