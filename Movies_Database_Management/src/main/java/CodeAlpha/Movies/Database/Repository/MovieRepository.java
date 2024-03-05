package CodeAlpha.Movies.Database.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import CodeAlpha.Movies.Database.Model.Movie;


public interface MovieRepository extends JpaRepository<Movie, Integer> {
	@Query("select m from Movie m where m.title=?1")
	public List<Movie> FindByTitle(String title);

}
