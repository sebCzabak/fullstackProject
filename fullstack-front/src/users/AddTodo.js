import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function AddTodo() {
  let navigate = useNavigate();

  const [task, setTasks] = useState({
    todos: "",
    description: "",
  });
  const { todos, description } = task;

  const onInputChange = (e) => {
    setTasks({ ...task, [e.target.name]: e.target.value });
  };
  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/api/todoItems/createTodo", task);
    navigate("/Todo");
  };
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Add new Todo</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="todos" className="form-lable">
                Task
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter your task's description."
                name="todos"
                value={todos}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="description" className="form-lable">
                Description
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter your task's description."
                name="description"
                value={description}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <button
              type="submit"
              className="btn btn-outline-primary "
              onClick={onSubmit}
              to="/Todo"
            >
              Submit
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
