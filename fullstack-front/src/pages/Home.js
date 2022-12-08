import React from "react";
import { Link } from "react-router-dom";

export default function Home() {
  return (
    <div className="container">
      <div className="row">
        « Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod
        tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim
        veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam,
        nisi ut aliquid ex ea commodi consequatur. Quis aute iure reprehenderit
        in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
        Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui
        officia deserunt mollit anim id est laborum. »
      </div>
      <Link className="btn btn-dark mx-2" to="/AddTodo">
        AddTodo
      </Link>
    </div>
  );
}
