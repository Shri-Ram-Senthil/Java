package edu.kec.entertainment.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.kec.entertainment.dao.DbConnector;
import edu.kec.entertainment.iservice.IMovieService;
import edu.kec.entertainment.model.Movie;

public class MovieService implements IMovieService {
	private DbConnector dbConnector = new DbConnector();

	@Override
	public boolean add(Movie movie) {
		boolean isAdded = false;
		System.out.println("Preparing insert query to add a movie.");
		String query = "INSERT INTO entertainment.movies(name, releasedOn, genre, rating) VALUES ('"+movie.getName()+"',"+movie.getReleasedOn()+",'"+movie.getGenre()+"',"+movie.getRating()+")";
		System.out.println("Query : " + query);
		System.out.println("Trying to get connection object.");
		dbConnector.getConnection();
		System.out.println("Database connected..");
		isAdded = dbConnector.insertOrUpdate(query);
		dbConnector.closeConnection();
		return isAdded;
	}

	@Override
	public LinkedList<Movie> getAllMovies() {
		LinkedList<Movie> movies = new LinkedList<Movie>();		
		String query = "SELECT id,name,releasedOn,genre,rating FROM entertainment.movies";
		dbConnector.getConnection();
		ResultSet resultSet = dbConnector.getDataFromTable(query);
		try {
			while(resultSet.next()) {
				Movie movie = new Movie();
				movie.setId(resultSet.getInt("id"));
				movie.setName(resultSet.getString("name"));
				movie.setReleasedOn(Short.parseShort(resultSet.getInt("releasedOn")+""));
				movie.setGenre(resultSet.getString("genre"));
				movie.setRating(Byte.parseByte(resultSet.getInt("rating") + ""));
				movies.add(movie);				
			}
			dbConnector.closeConnection();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public Movie getById(Integer id) {
		Movie movie = new Movie();
		String query = "SELECT id,name,releasedOn,genre,rating FROM entertainment.movies WHERE id = " + id;
		dbConnector.getConnection();
		ResultSet resultSet = dbConnector.getDataFromTable(query);
		try {
			while(resultSet.next()) {				
				movie.setId(resultSet.getInt("id"));
				movie.setName(resultSet.getString("name"));
				movie.setReleasedOn(Short.parseShort(resultSet.getInt("releasedOn")+""));
				movie.setGenre(resultSet.getString("genre"));
				movie.setRating(Byte.parseByte(resultSet.getInt("rating") + ""));			
			}
			dbConnector.closeConnection();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return movie;
	}
}