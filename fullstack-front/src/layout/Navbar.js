import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-dark bg-dark">
        <div className="container-fluid">
          <a className="navbar-brand" href="/Home">
            Fullstack app
          </a>

          <Link className="btn btn-outline-light" to="/register">
            Register User
          </Link>

          <Link className="btn btn-outline-light" to="/Todo">
            Todo
          </Link>
        </div>
      </nav>
    </div>
  );
}
