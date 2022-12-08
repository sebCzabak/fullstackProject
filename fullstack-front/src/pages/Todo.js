import axios from "axios";
import React, { Link, useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";

export default function Todo() {
  let navigate = useNavigate();
  const [task, setTasks] = useState([]);

  const { id } = useParams();

  useEffect(() => {
    loadTodos();
  }, []);

  const loadTodos = async () => {
    const response = await axios.get("http://localhost:8080/api/todoItems");
    setTasks(response.data);
  };
  const setDone = async (e) => {
    e.preventDefault();
    const response = await axios.put(
      `http://localhost:8080/api/todoItems/setDone/${id}`
    );
  };
  const deleteTask = async (id) => {
    const response = await axios.delete(
      `http://localhost:8080/api/todoItems/deleteTodo/${id}`
    );
    loadTodos();
  };
  const routeChange = () => {
    let path = `AddTodo`;
    navigate(path);
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Your Todos</h2>
        <button className="btn btn-success px-4" onClick={routeChange}>
          Add New Todo
        </button>
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col#">#</th>
              <th scope="col#">Description</th>
              <th scope="col#">Action</th>
            </tr>
          </thead>
          <tbody>
            {task.map((task, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{task.description}</td>
                <td>
                  <div className="form-check">
                    <input
                      className="form-check-input"
                      type="checkbox"
                      value=""
                      id="flexCheckDefault"
                    ></input>
                    <label
                      className="form-check-label"
                      htmlFor="flexCheckDefault"
                    ></label>
                  </div>
                  <button
                    className="btn btn-primary mx-2"
                    onClick={() => setDone(task.id)}
                  >
                    SetDone
                  </button>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deleteTask(task.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
