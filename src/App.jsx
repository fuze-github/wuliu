import React, { Component } from "react";
import "./style/index.less";
import Main from "./pages/main";
import Login from "./pages/login";
import {Provider} from 'mobx-react'
import store from "./stroe"
import { Redirect, Route } from "react-router";
import { userinformation } from "./request/network";
export default class App extends Component {
  render() {
    return (
      <div className="App">
        <Provider store={store}>
        <Route
          path="/main"
          render={(props) => {
            if (!userinformation()) {
              return <Redirect to="/login/llogin"></Redirect>;
            }
            return <Main></Main>;
          }}
        ></Route>
        <Route path="/login" component={Login}></Route>
        <Redirect to="/main/seedata" />
        </Provider>
      </div>
    );
  }
}
