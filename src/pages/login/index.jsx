import React, { Component } from 'react'
import { Route } from "react-router-dom";
import Regist from "./regist"
import Llogin from './login'
export default class Login extends Component {
  render() {
    return (
      <div className="login">
     
        <Route path="/login/regist" component={Regist} />
       <Route path="/login/llogin" component={Llogin}></Route>
        
        
      </div>
    )
  }
}

