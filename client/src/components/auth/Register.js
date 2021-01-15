import React, { useState } from "react";
import axios from 'axios';
import { Link, Redirect } from "react-router-dom";
import {toast} from 'react-toastify';

function Register({history}) {
  const [formData, setFormData] = useState({
    nom: "",
    prenom: "",
    email: "",
    age: "",
    tel: "",
    login: "",
    mdp: "",
    role: "adherant"
  });

  const { nom, prenom, email, age, tel, login, mdp } = formData;

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const res = await axios.post('http://localhost:8090/Rest/Api/user/signUp', formData)

    if (res.data) {
      localStorage.setItem("isAuth", true);
      localStorage.setItem("user", JSON.stringify(res.data));
      toast.success(`Welcome ${res.data.nom}`)
      history.push('/');
    }
  };

  const isAuth = localStorage.getItem('isAuth');

  if(isAuth) {
    return <Redirect to='/' />
  }

  return (
    <div className="container">
      <h1 className="sign-in">Sign up</h1>
      <form onSubmit={handleSubmit}>
      <div className="form-group">
          <label for="nom">Name</label>
          <input
            type="text"
            className="form-control"
            name="nom"
            placeholder="Enter name"
            value={nom}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label for="nom">Lastname</label>
          <input
            type="text"
            className="form-control"
            name="prenom"
            placeholder="Enter lastname"
            value={prenom}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label for="email">Email address</label>
          <input
            type="email"
            className="form-control"
            name="email"
            aria-describedby="emailHelp"
            placeholder="Enter email"
            value={email}
            onChange={handleChange}
          />
          <small id="emailHelp" className="form-text text-muted">
            We'll never share your email with anyone else.
          </small>
        </div>
        <div className="form-group">
          <label for="nom">Password</label>
          <input
            type="text"
            className="form-control"
            name="mdp"
            placeholder="Password"
            value={mdp}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label for="age">Age</label>
          <input
            type="text"
            className="form-control"
            name="age"
            placeholder="Age"
            value={age}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label for="tel">Phone Number</label>
          <input
            type="text"
            className="form-control"
            name="tel"
            placeholder="Put your phone number"
            value={tel}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label for="exampleInputPassword1">Username</label>
          <input
            type="text"
            className="form-control"
            name="login"
            placeholder="Put your username"
            value={login}
            onChange={handleChange}
          />
        </div>

        <small className="form-text">Already a member ?<Link to='/login'>  Sign in here</Link></small>

        <button type="submit" className="btn btn-primary mt-2">
          Register
        </button>
      </form>
    </div>
  );
}

export default Register;
