import React from "react";

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-dark bg-dark">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">
            Fullstack app
          </a>

          <button className="btn btn-outline-light">Register User</button>
        </div>
      </nav>
    </div>
  );
}
