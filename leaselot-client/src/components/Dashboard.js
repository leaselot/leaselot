import React from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import "../style/dashboard.css";

class Dashboard extends React.Component {
	render() {
		return (
			<div id="dashboard">
				<div id="img-container">
					<img id="logo" src={require("../style/images/logo_leaselot.png")}/>
				</div>
				<div id="cards-container">
					<div class="card-row">
					  <Card>
					    <Card.Img class="card-img" variant="top" src={require("../style/images/card-pics/doublequote.gif")} />
					    <Card.Body>
					      <Card.Title>Get a Quote</Card.Title>
					      <Card.Text>
					        Enter basic information about the lease, and get an estimated price using our price calculator.
					      </Card.Text>
					    </Card.Body>
					    <Card.Footer>
					      <a href="customer-quote"><Button variant="outline-primary">Quote</Button>{' '}</a>
					    </Card.Footer>
					  </Card>
					  <Card>
					    <Card.Img class="card-img" variant="top" src={require("../style/images/card-pics/sign-lease.jpg")} />
					    <Card.Body>
					      <Card.Title>Sign a Lease</Card.Title>
					      <Card.Text>
					        Is your customer ready to sign? Follow this link to create a contract and sign them up.
					      </Card.Text>
					    </Card.Body>
					    <Card.Footer>
					      <a href="lease-enrollment"><Button variant="outline-primary">Sign</Button>{' '}</a>
					    </Card.Footer>
					  </Card>
					</div>
					<div class="card-row">
					  <Card>
					    <Card.Img class="card-img" variant="top" src={require("../style/images/card-pics/history.png")} />
					    <Card.Body>
					      <Card.Title>Lease History</Card.Title>
					      <Card.Text>
					        View the history of leases at your dealership.
					      </Card.Text>
					    </Card.Body>
					    <Card.Footer>
					     	<a href="lease-history"><Button variant="outline-primary">History</Button>{' '}</a>
					    </Card.Footer>
					  </Card>
					  <Card>
					    <Card.Img class="card-img" variant="top" src={require("../style/images/card-pics/support.jpg")} />
					    <Card.Body>
					      <Card.Title>Support</Card.Title>
					      <Card.Text>
					        Contact our team directly for 24/7 support.
					      </Card.Text>
					    </Card.Body>
					    <Card.Footer>
					      <a href="support"><Button variant="outline-primary">Support</Button>{' '}</a>
					    </Card.Footer>
					  </Card>
					</div>
				</div>
			</div>
		);
	}
}

export default Dashboard;