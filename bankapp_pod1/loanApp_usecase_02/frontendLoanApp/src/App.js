import React, { Component } from 'react'
import { BrowserRouter as Router, Switch, Route, Redirect} from 'react-router-dom';
import './App.css';
import Educationloanpage from './pages/EducationLoanPage';
import HomeLoanPage from './pages/HomeLoanPage';
import Body from './components/Body';
import Footer from './components/Footer';


class App extends Component {
  state = {
    loggedIn: false
    }
    loginHandle = ()=>{
      this.setState(prevState => ({
        loggedIn: !prevState.loggedIn
      }))
    }

  
  render() {
    return ( 
      <Router>
          <div>
            <nav className="navbar navbar-light bg-info mx-auto py-3">
              <a className="navbar-brand">Bank Management System</a>
              <form className="form-inline">
                <input className="form-control mr-sm-2 btn-primary" type="button" placeholder="Login" value={this.state.loggedIn ? 'Log Out' : 'Log In'} onClick={this.loginHandle.bind(this)} />
              </form>
            </nav>
            <div className="body py-3">
              <Switch>
                <Route exact path="/" component={Body} />
                <Route exact path="/homeloan" exact strict 
                  render={()=>(this.state.loggedIn ? (<HomeLoanPage />) : (<Redirect to="/" />))} />
                <Route exact path="/eduloan" exact strict 
                  render={()=>(this.state.loggedIn ? (<Educationloanpage />) : (<Redirect to="/" />))} />
                <Route exact path="/cancel" component={Body} />
              </Switch>
            </div>
            <Footer />
          </div>  
      </Router> 
    );
    }
  } 

export default App;