import React, { useState } from "react";
import { Link, Redirect, withRouter } from "react-router-dom";
import axios from "axios";
import { toast } from "react-toastify";

function Login({history}) {
  const [formData, setFormdata] = useState({
    login: "",
    mdp: "",
  });

  const { login, mdp } = formData;

  const handleChange = (e) => {
    setFormdata({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const res = await axios.post("http://localhost:8090/Rest/Api/user/signIn", formData);

    if (res.data) {
      localStorage.setItem("isAuth", true);
      localStorage.setItem("user", JSON.stringify(res.data));
      window.location.reload()
      console.log(res.data)
      toast.success(`Welcome ${res.data.nom}`)
      history.push('/');
    } else {
      toast.error('Wrong Credentials')
    }
  };

  const isAuth = localStorage.getItem('isAuth');

  if(isAuth) {
    return <Redirect to='/' />
  }


  return (
    <div className="container">
      <h1 className="sign-in">Sign in</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label for="exampleInputEmail1">Username</label>
          <input
            type="text"
            className="form-control"
            name="login"
            placeholder="Enter your Username"
            value={login}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label for="exampleInputPassword1">Password</label>
          <input
            type="password"
            className="form-control"
            name="mdp"
            placeholder="Enter your Password"
            value={mdp}
            onChange={handleChange}
          />
        </div>

        <small className="form-text">
          You don't have an account yet ?<Link to='/register'> Sign up here</Link>
        </small>

        <button type="submit" className="btn btn-primary mt-4">
          Login
        </button>
      </form>
    </div>
  );
}

export default withRouter(Login);
