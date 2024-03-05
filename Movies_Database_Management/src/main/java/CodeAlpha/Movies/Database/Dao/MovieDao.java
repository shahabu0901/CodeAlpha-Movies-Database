package CodeAlpha.Movies.Database.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import CodeAlpha.Movies.Database.Model.Movie;
import CodeAlpha.Movies.Database.Repository.MovieRepository;

@Repository
public class MovieDao {
	@Autowired
	private MovieRepository movieRepository;

	// Add Movies
	public Movie SaveMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	// FindByTitle
	public List<Movie> FindByTitle(String title) {
		return movieRepository.FindByTitle(title);
	}

	// FindMoviesById
	public Optional<Movie> FindById(int id) {
		return movieRepository.findById(id);
	}

	// DeleteMoviesById
	public boolean DeleteById(int id) {
		Optional<Movie> RecMovie = FindById(id);
		if (RecMovie.isPresent()) {
			movieRepository.deleteById(id);
			return true;
		}
		return false;
	}

	// FindAllMovies
	public List<Movie> FindAllMovies() {
		return movieRepository.findAll();
	}
}
