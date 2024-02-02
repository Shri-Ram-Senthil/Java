package edu.kec.entertainment.iservice;

import java.util.LinkedList;

import edu.kec.entertainment.model.Movie;

public interface IMovieService {
	public boolean add(Movie movie);

	LinkedList<Movie> getAllMovies();
	public Movie getById(Integer id);
}
