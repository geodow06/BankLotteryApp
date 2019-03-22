import React, { Component } from 'react';
import axios from 'axios';
import './App.css';

class Money extends Component {
    constructor(props) {
        super(props);
        this.state = {
            money: ""
        }
        this.yes = (e) => {
            axios.get("http://192.168.1.120:8080/checkWinner/" + this.props.id).then(response => {
                this.setState({ money: response.data })
            })
        }
        this.no = (e) => {
            props.no();
        }
    }
    render() {
        axios.get("http://192.168.1.120:8080/getAccountById/" + this.props.id).then(response => {
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

export default Money;