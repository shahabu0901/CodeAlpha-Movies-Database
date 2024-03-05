package CodeAlpha.Movies.Database.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import CodeAlpha.Movies.Database.Dao.MovieDao;
import CodeAlpha.Movies.Database.Dto.ResponseStructure;
import CodeAlpha.Movies.Database.Exception.IdNotFoundException;
import CodeAlpha.Movies.Database.Exception.MoviesNotFoundException;
import CodeAlpha.Movies.Database.Model.Movie;

@Service
public class MovieService {
	@Autowired
	private MovieDao movieDao;

	// Save Movies

	public ResponseEntity<ResponseStructure<Movie>> SaveMovies(Movie movie) {
		ResponseStructure<Movie> responseStructure = new ResponseStructure<>();
		movie = movieDao.SaveMovie(movie);
		responseStructure.setData(movie);
		responseStructure.setMessage("Movies Added Successfull");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure, HttpStatus.CREATED);
	}

	// FindMoviesByTitle
	public ResponseEntity<ResponseStructure<List<Movie>>> FindByTitle(String title) {
		ResponseStructure<List<Movie>> structure = new ResponseStructure<>();
		List<Movie> movies = movieDao.FindByTitle(title);
		if (movies.size() > 0) {
			structure.setData(movies);
			structure.setMessage("Movies Found Success");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Movie>>>(structure, HttpStatus.OK);
		}
		throw new MoviesNotFoundException("Movies Not Found");
	}

	// FindById
	public ResponseEntity<ResponseStructure<Movie>> FindById(int id) {
		Optional<Movie> RecMovies = movieDao.FindById(id);
		ResponseStructure<Movie> responseStructure = new ResponseStructure<>();
		if (RecMovies.isPresent()) {
			responseStructure.setData(RecMovies.get());
			responseStructure.setMessage("Movies Found");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Movie>>(responseStructure, HttpStatus.OK);
		}
		throw new IdNotFoundException("Id Not Found  ");
	}

	// Delete Movies
	public ResponseEntity<ResponseStructure<String>> DeleteById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		boolean deleted = movieDao.DeleteById(id);
		if (deleted) {
			responseStructure.setData("Movies Deleted Successfully");
			responseStructure.setMessage("Movies Found");
			responseStructure.setStatusCode(HttpStatus.OK.value());
		}
		responseStructure.setData("Movies Not Found");
		responseStructure.setMessage("Invalid Movies Id");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	// Find All Movies
	public ResponseEntity<ResponseStructure<List<Movie>>> findAllStudent() {
		ResponseStructure<List<Movie>> structure = new ResponseStructure<>();
		structure.setData(movieDao.FindAllMovies());
		structure.setMessage("List of All Students");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Movie>>>(structure, HttpStatus.OK);
	}
}
