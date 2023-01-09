package com.mvs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvs.entity.Movie;
import com.mvs.repository.MovieRepo;
import com.mvs.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo repo;
	public Movie saveMovie(Movie movie) {
		return repo.save(movie);
	}
	public List<Movie> getMovies(){
		return repo.findAll();
	}
	public Movie getMovieByName(String movieName) {
		return repo.findById(movieName).orElse(null);
	}
	public Movie updateMovie(Movie movie) {
		Movie existingMovie=repo.findById(movie.getMovieName()).orElse(null);
		existingMovie.setMovieName(movie.getMovieName());
		existingMovie.setMultiplex(movie.getMultiplex());
		existingMovie.setScreen(movie.getScreen());
		existingMovie.setSeatCount(movie.getSeatCount());
		existingMovie.setTime(movie.getTime());
		existingMovie.setTicketPrice(movie.getTicketPrice());
		return repo.save(existingMovie);
	}
	public String deleteMovie(String movieName) {
		repo.deleteById(movieName);
		return "Movie deleted with name : "+movieName;
	}
}
