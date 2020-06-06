import React from 'react';
import "../style/quote.css";

class Quote extends React.Component {

	constructor() {
		super();
		this.state = {
			clicked: false
		}

		this.buttonClicked = this.buttonClicked.bind(this);
	}

	buttonClicked() {
		this.setState({
			clicked: true
		});
	}

	render() {
		return (
			<div class="login-page">
			  <img id="logo" src={require("../style/images/logo_leaselot.png")}/>
			  <div class="form">
			  	<h3>Estimate Lease</h3>
			    <div class="login-form">
			      <input type="text" placeholder="Make"/>
			      <input type="text" placeholder="Model"/>
			      <input type="text" placeholder="Year" />
			      <input type="text" placeholder="Mileage" />
			      <button onClick={this.buttonClicked}>Get Estimate</button>
			    </div>
			    <br/>
			    { 
			   		this.state.clicked && 
			    		<h3>Lease Estimate: $237</h3>
				}
			  </div>
			</div>
		);
	}
}

export default Quote;