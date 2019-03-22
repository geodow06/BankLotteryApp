import React, { Component } from 'react';
import axios from 'axios';
import './App.css';
import Money from './Money.js';

class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: "",
        }
        this.register = (e) => {
            if (this.apiFirstName.value === "" || this.apiLastName.value === "") {
                alert("Both fields need to be filled");
            }
            else {
                axios.post("http://192.168.1.120:8080/createAccount", { "name": this.apiFirstName.value + " " + this.apiLastName.value }).then(response => {
                    console.log(response.data);
                    this.setState({ id: response.data })
                    //this.apiFirstName.value = "";
                    //this.apiLastName.value = "";
                })
            }
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
            return (
                <Money id={this.state.id} no={this.no} />
            )
        }
    }
}

export default Register;