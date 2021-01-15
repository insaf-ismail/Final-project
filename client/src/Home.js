import React, { Fragment, useState, useEffect } from "react";
import { Link, Redirect } from "react-router-dom";
import "./App.css";
import BookItem from "./components/BookItem";
import axios from "axios";

function Home() {
  const [books, setBooks] = useState([]);


  useEffect(async () => {
    const res = await axios.get("http://localhost:8090/Rest/Api/livre/getAll");
    
  
    setBooks(res.data);
  }, []);

  const updateBooks = books => {
    setBooks(books)
  }

  const isAuth = localStorage.getItem("isAuth");
  if (!isAuth) {
    console.log(isAuth);
    return <Redirect to="/login" />;
  }

  return (
    <div className="app-container">
      <h1 className="title"> The best book library </h1>
      <p style={{ textAlign: "center", color: "white" }}>Couldn't be more easier to find your book</p>

      <div className="book-store">
        {books.map((book, i) => (
          <Fragment key={i}>
            <BookItem book={book} updateBooks={updateBooks}/>
          </Fragment>
        ))}
      </div>
    </div>
  );
}

export default Home;
