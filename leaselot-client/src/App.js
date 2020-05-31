import React from 'react';
import {
  BrowserRouter as Router,
  Route,
  Switch
} from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import Dashboard from './components/Dashboard';
import Enrollment from './components/Enrollment';
import History from './components/History';
import Home from './components/Home';
import Login from './components/Login';
import Quote from './components/Quote';
import Support from './components/Support';

function App() {
  return (
    <Router>
      <Switch>
        <Route
          exact
          path="/"
          render={() =>(
            <Home />
          )}
        />
        <Route
          path="/login"
          render={() => (
            <Login />
          )}
        />
        <Route
          path="/dashboard"
          render={() => (
            <Dashboard />
          )}
        />
        <Route
          path="customer-quote"
          render={() => (
            <Quote />
          )}
        />
        <Route
          path="lease-enrollment"
          render={() => (
            <Enrollment />
          )}
        />
        <Route
          path="lease-history"
          render={() => (
            <History />
          )}
        />
        <Route
          path="support"
          render={() => (
            <Support />
          )}
        />
      </Switch>
    </Router>
  );
}

export default App;
