import React, { useState } from "react";
import style from "./SearchMovies.module.css";
import SearchForm from "../component/SearchForm";
import axios from "axios";
import SingleMovie from "../component/SingleMovie";

const SearchMovies = () => {
  const [movies, setMovies] = useState([]);
  const getMoviesByName = async (movie) => {
    let response = await axios.get("http://localhost:8080/movies/by/" + movie);
    let data = await response.data;
    console.log(data.data);
    setMovies(data.data);
  };
  return (
    <div className={style.main}>
      <div className={style.sectionCenter}>
        <SearchForm getMoviesByName={getMoviesByName} />
        {movies.length === 0 ? (
          ""
        ) : (
          <div style={{ position: "absolute", top: "0" }}>
            {" "}
            <SingleMovie {...movies[0]} />{" "}
          </div>
        )}
      </div>
    </div>
  );
};

export default SearchMovies;
