import React from "react";
import "./SingleMovie.css";

const SingleMovie = ({
  title,
  image_url,
  release_date,
  duration,
  gener,
  description,
}) => {
  return (
    <div className="pink">
      <div className="movie_card" id="tomb">
        <div className="info_section">
          <div className="movie_header">
            <img className="locandina" src={image_url} />
            <h1>{title}</h1>
            <h4>{release_date}</h4>
            <span className="minutes">{duration}</span>
            <p className="type">{gener.join(", ")}</p>
          </div>

          <div className="movie_desc">
            <p className="text">{description}</p>
          </div>
        </div>
        <div
          className="blur_back tomb_back"
          style={{ background: `url(${image_url})` }}
        ></div>
      </div>
    </div>
  );
};

export default SingleMovie;
