import axios from "axios";
import React, { useEffect, useState } from "react";
import SingleMovie from "../component/SingleMovie";

const AllMovies = () => {
  const [movies, setMovies] = useState([]);
  const fetchData = async () => {
    let res = await axios.get("http://localhost:8080/movieall");
    let data = res.data;
    setMovies(data.data);
  };

  useEffect(() => {
    fetchData();
  }, []);
  return (
    <div>
      {movies.map((movie) => {
        return <SingleMovie {...movie} />;
      })}
    </div>
  );
};

export default AllMovies;
