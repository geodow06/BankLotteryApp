import React, { Component } from 'react';
//import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import axios from 'axios';
import './App.css';
import Register from './Register.js';


class App extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <Register />
    );
  }
}

export default App;
