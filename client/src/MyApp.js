import React, {useState, useEffect} from "react";
import {
  BrowserRouter as Router,
  Route,
  Switch
} from "react-router-dom";

import Home from "./Home";
import Nav from "./components/Nav";
import Login from "./components/auth/Login";
import Register from "./components/auth/Register";
import AddAdmin from "./components/AddAdmin";
import { ToastContainer } from "react-toastify";

import 'react-toastify/dist/ReactToastify.css';
import BookItem from "./components/BookItem";
import AddBook from "./components/AddBook";

function MyApp() {

  const [isAuth, setIsAuth] = useState(localStorage.getItem("isAuth"))
  const [user, setUser] = useState(JSON.parse(localStorage.getItem("user")));

 
 
  return (
    <Router>
      <Nav isAuth={isAuth} user={user} />
      <ToastContainer position="top-center"/>
      <Switch>
        <Route exact path="/home" component={Home} />
        <Route exact path="/login" component={Login} />
        <Route exact path="/register" component={Register} />
        <Route exact path="/add-admin" component={AddAdmin} />
        <Route exact path="/" component={Home} />
        <Route exact path="/book" component={BookItem} />
        <Route exact path="/add-book" component={AddBook} />
      </Switch>
    </Router>
  );
}

export default MyApp;
