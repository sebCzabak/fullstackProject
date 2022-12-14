import "./App.css";
import React, { useState } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import Login from "./pages/Login";
import AdminPage from "./users/AdminPage";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Register from "./users/Register";
import EditUser from "./users/EditUser";
import ViewUser from "./users/ViewUser";
import Home from "./pages/Home";
import Todo from "./pages/Todo";
import AddTodo from "./users/AddTodo";

function App() {
  const [currentForm, setCurrentForm] = useState("login");
  const toggleForm = (formName) => {
    setCurrentForm(formName);
  };
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route exact path="/Login" element={<Login />} />
          <Route exact path="/register" element={<Register />} />
          <Route exact path="/adminPage" element={<AdminPage />} />
          <Route exact path="/editUser/:id" element={<EditUser />} />
          <Route exact path="/ViewUser/:id" element={<ViewUser />} />
          <Route exact path="/Home" element={<Home />} />
          <Route exact path="/Todo" element={<Todo />} />
          <Route exact path="/Todo/AddTodo" element={<AddTodo />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
