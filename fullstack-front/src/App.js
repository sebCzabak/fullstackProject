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
          <Route exact path="/Login" element={<Login />} />
          <Route exact path="/register" element={<Register />} />
          <Route exact path="/adminPage" element={<AdminPage />} />
          <Route exact path="/editUser/:id" element={<EditUser />} />
          <Route exact path="/ViewUser/:id" element={<ViewUser />} />
          <Route exact path="/Home/:id" element={<Home />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
