import React, { useState } from "react";
import style from "./AddMovie.module.css";
import { TbMovie } from "react-icons/tb";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";

const AddMovies = () => {
  const [title, setTitle] = useState("");
  const [director, setDirector] = useState("");
  const [actor, setActor] = useState("");
  const [actress, setActress] = useState("");
  const [release_date, setTRelease_date] = useState("");
  const [description, setDescription] = useState("");
  const [duration, setDuration] = useState("");
  const [rating, setRating] = useState("");
  const [image_url, setImage_Url] = useState("");
  const [language, setLanguage] = useState("");
  const [gener, setGener] = useState("");

  const fetchData = () => {
    const data = {
      title,
      director,
      actor,
      actress,
      release_date,
      description,
      duration,
      rating,
      image_url,
      language: language.split(","),
      gener: gener.split(","),
    };
    console.log(data);

    axios
      .post(`http://localhost:8080/movies`, data)
      .then((res) => {
        console.log(res);
        toast.success("Movies Registerd", { draggable: true, theme: "dark" });
        alert("Movie Saved Successfull");
      })
      .catch((e) => console.log(e));
  };

  const submitHandler = (e) => {
    e.preventDefault();
    fetchData();
  };

  return (
    <>
      <div>
        <ToastContainer position="top-center" />
      </div>
      <div className={style.form_container}>
        <form onSubmit={submitHandler}>
          <h2>
            <TbMovie /> Add Movies <TbMovie />
          </h2>
          <input
            type="text"
            placeholder="Enter Title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
          <input
            type="text"
            placeholder="Enter Director"
            value={director}
            onChange={(e) => setDirector(e.target.value)}
          />
          <input
            type="text"
            placeholder="Enter actor"
            value={actor}
            onChange={(e) => setActor(e.target.value)}
          />
          <input
            type="text"
            placeholder="actoress"
            value={actress}
            onChange={(e) => setActress(e.target.value)}
          />
          <input
            type="text"
            placeholder="release_date"
            value={release_date}
            onChange={(e) => setTRelease_date(e.target.value)}
          />
          <input
            type="text"
            placeholder="description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
          <input
            type="text"
            placeholder="duration"
            value={duration}
            onChange={(e) => setDuration(e.target.value)}
          />

          <input
            type="text"
            placeholder="rating"
            value={rating}
            onChange={(e) => setRating(e.target.value)}
          />
          <input
            type="text"
            placeholder="image_url"
            value={image_url}
            onChange={(e) => setImage_Url(e.target.value)}
          />
          <input
            type="text"
            placeholder="language"
            value={language}
            onChange={(e) => setLanguage(e.target.value)}
          />
          <input
            type="text"
            placeholder="gener"
            value={gener}
            onChange={(e) => setGener(e.target.value)}
          />

          <button type="submit" className={style.btn}>
            Submit
          </button>
        </form>
      </div>
    </>
  );
};

export default AddMovies;
