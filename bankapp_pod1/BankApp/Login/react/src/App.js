import React from 'react';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {  Login } from "./Login";
import {RegisterUser} from "./RegisterUser"
import {  Router, Switch, Route, Link } from "react-router-dom";
import Header from './Header'; 
import Footer from './Footer';
import Home1 from './Home1';
import RegisterSucess from './RegisterSucess'

import { history } from './Helpers';



class App extends React.Component{
  constructor(props) {
    super(props);

    history.listen((location, action) => {
      // clear alert on location change
     // this.props.clearAlerts();
  });
}

render() {
 
  return (
      <div className="jumbotron jumbotron-fluid">
          <div className=".container-fluid">
          <Header></Header>
              <div>
              <div className="outer">
        <div className="inner">
                  <Router history={history}>
                      <Switch>
                          <privateRoute exact path="/" component={Home1} />
                          <Route path="/login" component={Login} />
                          <Route path="/register" component={RegisterUser} /> 
                          <Route path="/home" component={Home1} /> 
                          <Route path="/RegisterSucess" component={RegisterSucess} /> 
                      </Switch>
                  </Router>
                  </div>
                  </div>
              </div>
              <Footer></Footer>
          </div>
      </div>
  );
}
}


export default App;


