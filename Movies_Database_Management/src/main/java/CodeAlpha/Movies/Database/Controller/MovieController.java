package CodeAlpha.Movies.Database.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import CodeAlpha.Movies.Database.Dto.ResponseStructure;
import CodeAlpha.Movies.Database.Model.Movie;
import CodeAlpha.Movies.Database.Service.MovieService;

@RestController
@CrossOrigin
public class MovieController {
	@Autowired
	private MovieService movieService;

	@PostMapping("/movies")
	public ResponseEntity<ResponseStructure<Movie>> SaveMovie(@RequestBody Movie movie) {
		return movieService.SaveMovies(movie);
	}

	@GetMapping("/movies/by/{title}")
	public ResponseEntity<ResponseStructure<List<Movie>>> FindByTitle(@PathVariable String title) {
		return movieService.FindByTitle(title);
	}

	@GetMapping("/movies/{id}")
	public ResponseEntity<ResponseStructure<Movie>> FindById(@PathVariable int id) {
		return movieService.FindById(id);
	}

	@DeleteMapping("movies/{id}")
	public ResponseEntity<ResponseStructure<String>> DeleteById(@PathVariable int id) {
		return movieService.DeleteById(id);
	}

	@GetMapping("/movieall")
	public ResponseEntity<ResponseStructure<List<Movie>>> findAllStudent() {
		return movieService.findAllStudent();
	}
}
