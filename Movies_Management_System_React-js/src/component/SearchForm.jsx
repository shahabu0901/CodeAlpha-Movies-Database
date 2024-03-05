import React, { useState } from "react";
import style from "./SearchForm.module.css";
const SearchForm = ({ getMoviesByName }) => {
  const [movie, setMovie] = useState("");
  const submitHandler = (e) => {
    e.preventDefault();
    getMoviesByName(movie);
  };
  return (
    <div>
      <form className={style.form} onSubmit={submitHandler}>
        <input
          type="text"
          placeholder="Enter Movie Name"
          value={movie}
          onChange={(e) => setMovie(e.target.value)}
        />
        <button type="submit" className={style.btn}>
          Search
        </button>
      </form>
    </div>
  );
};

export default SearchForm;
