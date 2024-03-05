import React from "react";
import { Link } from "react-router-dom";
import style from "./Navbar.module.css";

const Navbar = () => {
  return (
    <nav className={style.navbar}>
      <div className={style.navCenter}>
        <h1>Movies Management System</h1>
        <ul>
          <li>
            <Link to="/">home</Link>
          </li>
          <li>
            <Link to="/add">add movies</Link>
          </li>
          <li>
            <Link to="/allMovies">all movies</Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
