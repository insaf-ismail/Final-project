import React, { useState } from "react";
import axios from "axios";
import { toast } from "react-toastify";
import { Redirect } from "react-router-dom";

function AddBook({ history }) {
  const [formData, setFormData] = useState({
    nom: "",
    auteur: "",
    description: "",
  });

  const [files, setFiles] = useState('');

  const { nom, auteur, description } = formData;

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const res = await axios.post("http://localhost:8090/Rest/Api/livre/addLivre", formData);
    setFormData({
      nom: "",
      auteur: "",
      description: ""
    })
    if (res.data) {
      toast.success("Book successfully added");
      files.map((file, index) => {
        let formData = new FormData();
        formData.append("file", file)
        const headers = {
          'Content-Type': 'multipart/form-data',
          id:res.data.id
        }
        let config = {
          headers
      }
      return new Promise((resolve, reject) => {
        return axios.post("http://localhost:8090/Rest/Api/livre/upload", formData, config)
            .then(
                (res) => {
                    resolve(res);
                    history.push('/')
                })
            .catch(err => {
                reject(err);
            })
    })
      })
      
    }

  };


  const getFilesInfo = (e) => {
    if (e.target) {
      setFiles(Object.values(e.target.files))
    } else {
      setFiles(Object.values(e))
    }
  }

  return (
    <div className="container">
      <div className="form-floating mb-3">
        <label style={{ color: "white" }}>Title</label>
        <input
          type="text"
          className="form-control"
          placeholder="Title"
          name="nom"
          value={nom}
          onChange={handleChange}
        />
      </div>
      <div className="form-floating mb-3">
        <label style={{ color: "white" }}>Author</label>
        <input
          type="text"
          className="form-control"
          placeholder="Author"
          name="auteur"
          value={auteur}
          onChange={handleChange}
        />
      </div>
      <div className="form-floating mb-3">
        <label style={{ color: "white" }}>Description</label>
        <textarea
          className="form-control"
          placeholder="Leave a description here"
          style={{ height: "100px" }}
          name="description"
          value={description}
          onChange={handleChange}
        />
      </div>
      <div className="form-floating">
        <label style={{ color: "white" }}>Upload book</label>
        <div style={{ display: "flex", justifyContent: "space-between" }}>
          <input type="file" name="file" onChange={getFilesInfo} />
          <button
            type="submit"
            className="btn btn-success"
            onClick={handleSubmit}
          >
            {" "}
            Add book{" "}
          </button>
        </div>
      </div>
    </div>
  );
}

export default AddBook;
