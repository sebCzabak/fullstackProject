import React from "react";

export default function Login() {
  function submitData() {
    console.log("I'm here");
  }
  return (
    <div className="container">
      <div className="mb-3">
        <label htmlFor="formGroupExampleInput" className="form-label">
          Email
        </label>
        <input
          type="text"
          className="form-control"
          id="formGroupExampleInput"
          placeholder="Please enter your email."
        ></input>
      </div>
      <div className="mb-3">
        <label htmlFor="formGroupExampleInput" className="form-label">
          Password
        </label>
        <input
          type="text"
          className="form-control"
          id="formGroupExampleInput"
          placeholder="Please enter your password."
        ></input>
      </div>
      <button className="btn btn-primary" onClick={submitData} to={"/"}>
        Submit
      </button>
    </div>
  );
}
