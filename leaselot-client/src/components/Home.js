import React from 'react';
import "../style/homepage.css"

class Home extends React.Component {
	render() {
		return (
			<div id="home-page">
				<div id="center-box">
					<img id="logo" src={require("../style/images/logo_leaselot.png")} />
					<div id="button-box">
						<div class="button" id="login-button"><a class="button-link" href="login">Log In</a></div>
						<div class="button" id="signup-button">Sign Up</div>
					</div>
				</div>
			</div>
		);
	}
}

export default Home;