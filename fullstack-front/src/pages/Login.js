import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function Login() {
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  let navigate = useNavigate();

  const onSubmit = async (e) => {
    e.preventDefault();
    console.log(email);
    await axios.post("http://localhost:8080/api/login/${email,password}");
    navigate("/Home/${id}");
  };
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <form onSubmit={onSubmit}>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">
                Email
              </label>
              <input
                className="form-control"
                id="formGroupInput"
                value={email}
                placeholder="Please enter your email."
                onChange={(e) => setEmail(e.target.value)}
                type="text"
              />
            </div>

            <label htmlFor="formGroupInput" className="form-label">
              Passowrd
            </label>
            <input
              type="password"
              className="form-control"
              id="password"
              value={password}
              placeholder="Please enter your password."
              onChange={(e) => setPassword(e.target.value)}
            />
          </form>

          <button className="btn btn-primary" onClick={onSubmit} to="/">
            Submit
          </button>
          <div className="row">
            <Link to="/register">Don't have an account? Register here.</Link>
          </div>
        </div>
      </div>
    </div>
  );
}
