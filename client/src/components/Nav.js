import React, { Fragment, useEffect, useState } from "react";
import { Link } from "react-router-dom";

function Nav({ isAuth, user }) {

  const [isAuthenticated, setIsAuth] = useState(false)
  

useEffect(() => {
  setIsAuth(isAuth)
}, [])

  return (
    <nav className="navbar navbar-light bg-light justify-content-between">
      <a href="/#" className="navbar-brand">
        Book Store
      </a>
      <div className="form-inline">
     
        {user && user.role == "admin" && (
          <Fragment>
            <Link to="/add-admin" className="btn btn-info btn-add-admin">
              Add Admin
            </Link>
            <Link to="/add-book" className="btn btn-primary btn-add-admin">
              Add Book
            </Link>
          </Fragment>
        )}
      </div>
      <div className="btn btn-secondary">
        {isAuthenticated === "true" ? (
          <a
            href="/#"
            className="navbar-item"
            onClick={() => {
              localStorage.removeItem("isAuth");
              localStorage.removeItem("user");
              setIsAuth(false)
              window.location.reload();
            }}
            style={{
              cursor: "pointer",
              textDecoration: "none",
              color: "White",
            }}
          >
            Logout
          </a>
        ) : (
          <Link
            to="/login"
            className="navbar-item"
            style={{
              cursor: "pointer",
              textDecoration: "none",
              color: "White",
            }}
          >
            Login
          </Link>
        )}
      </div>
    </nav>
  );
}

export default Nav;
