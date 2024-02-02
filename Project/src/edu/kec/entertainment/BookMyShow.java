//package edu.kec.entertainment;
//
//import edu.kec.entertainment.model.Movie;
//
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.SQLException;
////import java.sql.Statement;
//
//public class BookMyShow {
//
//	public static void main(String[] args) {
//		Movie movie = new Movie(0, "Godzilla", Short.parseShort("2007"), "SciFi",Byte.parseByte("4"));
//		IMovieService movieService = new MovieService();
//		
////		Connection connection = null;
////		try {
////			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment", "root", "");
////			String query = "INSERT INTO entertainment.movies (name, releasedOn, genre, rating) VALUES ('Leo', 2023, 'Action', 4.5)";
////			Statement statement = connection.createStatement();
////			statement.execute(query);
////			System.out.println("Inserted....");
////		} catch (SQLException e) {
////			e.printStackTrace();
////		} finally {
////			if (connection != null) {
////				try {
////					connection.close();
////				} catch (SQLException e) {
////					e.printStackTrace();
////				}
////			}
////		}
//	}
//}

package edu.kec.entertainment;

import java.util.LinkedList;

import edu.kec.entertainment.iservice.IMovieService;
import edu.kec.entertainment.model.Movie;
import edu.kec.entertainment.service.MovieService;

public class BookMyShow {

	public static void main(String[] args) {
		IMovieService movieService = new MovieService();
//		Movie movie = new Movie(0,"Godzilla",Short.parseShort("2007"),"SciFi",Byte.parseByte("4"));
//		if(movieService.add(movie)) {
//			System.out.println("Movie added.");
//		}else {
//			System.out.println("Server is busy. Please try again later.");
//		}
		LinkedList<Movie> movieList = movieService.getAllMovies();	
		for(Movie movie : movieList) {
			System.out.println(movie.getId() + "\t" + movie.getName() + "\t" + movie.getReleasedOn());
		}
	}
}