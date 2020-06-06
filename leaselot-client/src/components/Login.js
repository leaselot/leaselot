import React from 'react';
import '../style/login.css';

class Login extends React.Component {
	render() {
		return (
			<div class="login-page">
			  <img id="logo" src={require("../style/images/logo_leaselot.png")}/>
			  <div class="form">
			    <form class="login-form">
			      <input type="text" placeholder="username"/>
			      <input type="password" placeholder="password"/>
			      <button><a id="button-link" href="dashboard">login</a></button>
			    </form>
			  </div>
			</div>
		);
	}
}

export default Login;