import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function Register(props) {
  let navigate = useNavigate();

  const [user, setUser] = useState({
    firstName: "",
    userName: "",
    email: "",
    password: "",
  });
  const { firstName, userName, email, password } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };
  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/api/registration", user);
    navigate("/Home");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Register User</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="firstName" className="form-label">
                First Name
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter your First Name"
                name="firstName"
                value={firstName}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="userName" className="form-label">
                UserName
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter your User Name"
                name="userName"
                value={userName}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">
                Email
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter your email"
                name="email"
                value={email}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="password" className="form-label">
                Password
              </label>
              <input
                type="password"
                className="form-control"
                placeholder="**********"
                id="password"
                name="password"
                value={password}
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <button
              type="submit"
              className="btn btn-outline-primary "
              to="/Home"
            >
              Submit
            </button>
            <Link
              onClick={() => props.onFormSwitch("/Login")}
              className="btn btn-outline-danger mx-2"
              to="/Login"
            >
              Already Have an account? Just Login in.
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
