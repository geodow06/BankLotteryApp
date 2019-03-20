import React, { Component } from 'react';
//import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import axios from 'axios';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "",
      money: ""
    }
    this.register = (e) => {
      if (this.apiFirstName.value === "" || this.apiLastName.value === "") {
        alert("Both fields need to be filled");
      }
      else {
        axios.post("http://localhost:8080/createAccount", { "name": this.apiFirstName.value + " " + this.apiLastName.value }).then(response => {
          console.log(response.data);
          this.setState({ id: response.data })
          //this.apiFirstName.value = "";
          //this.apiLastName.value = "";
        })
      }
    }
    this.yes = (e) => {
      axios.get("http://localhost:8080/checkWinner/" + this.state.id).then(response => {
        this.setState({ money: response.data })
      })
    }
    this.no = (e) => {
      this.setState({
        id: "",
        money: ""
      })
    }
  }
  render() {
    if (this.state.id === "") {
      return (
        <div className="App">
          <header>
            <a className="Form">
              First Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Last Name<br />
              <input type="text" name="fname" required ref={(input) => this.apiFirstName = input} />
              <input type="text" name="lname" required ref={(input) => this.apiLastName = input} /><br />
              <button onClick={this.register}>Login</button><br />
            </a>
          </header>
        </div>
      );
    }
    else {
      axios.get("http://localhost:8080/getAccountById/" + this.state.id).then(response => {
        this.setState({
          name: response.data.name,
          accountId: response.data.accountId
        })
      })
      if (this.state.money === "") {
        return (
          <div className="App">
            <header>
              <p>
                Hello {this.state.name}, your new account ID is {this.state.accountId}. Would you like to check your starting balance?
            </p>
              <button onClick={this.yes}>Yes</button>
              <button onClick={this.no}>No</button>
            </header>
          </div>
        );
      }
      else if (this.state.money === "$0") {
        return (
          <div className="App">
            <header>
              <p>
                Hello {this.state.name}, your new account ID is {this.state.accountId}. Your starting balance is {this.state.money}. Unlucky, huh?
              </p>
              <button onClick={this.no}>Leave</button>
            </header>
          </div>
        )
      }
      else {
        return (
          <div className="App">
            <header>
              <p>
                Hello {this.state.name}, your new account ID is {this.state.accountId}. Your starting balance is {this.state.money}, congrats!
              </p>
              <button onClick={this.no}>Leave</button>
            </header>
          </div>
        )
      }
    }
  }
}

export default App;
