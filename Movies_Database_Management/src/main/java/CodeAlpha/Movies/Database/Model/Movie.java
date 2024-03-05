package CodeAlpha.Movies.Database.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String director;
	@Column(nullable = false)
	private String actor;
	@Column(nullable = false)
	private String actress;
	@Column(nullable = false)
	private LocalDate release_date;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private String duration;
	@Column(nullable = false)
	private int rating;
	@Column(nullable = false)
	private String image_url;
	@Column(nullable = false)
	private List<String> language;
	@Column(nullable = false)
	private List<String> gener;
}
