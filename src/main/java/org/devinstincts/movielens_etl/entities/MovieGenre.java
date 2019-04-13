package org.devinstincts.movielens_etl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * <pre>
 * <b>Description : </b>
 * Entity to represents the movie_genres table.
 * 
 * @author $Author: devinstincts $ 
 * </pre>
 */
@Entity
@Table(name = "movie_genres", uniqueConstraints = { @UniqueConstraint(columnNames = { "movie", "genre" }) })
public class MovieGenre {

    @Id
    private MovieGenreCompositeKey id;

    public MovieGenreCompositeKey getId() {
        return id;
    }

    public void setId(MovieGenreCompositeKey id) {
        this.id = id;
    }

}
