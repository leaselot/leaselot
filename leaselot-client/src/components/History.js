import React from 'react';
import '../style/history.css';

class History extends React.Component {
	render() {
		return (
			<div id="history">
				<div class="table-title">
					<h3>Lease History</h3>
					</div>
					<table class="table-fill">
					<thead>
					<tr>
						<th class="text-left">First Name</th>
						<th class="text-left">Last Name</th>
						<th class="text-left">Phone Number</th>
						<th class="text-left">Email</th>
						<th class="text-left">VIN</th>
						<th class="text-left">Make</th>
						<th class="text-left">Model</th>
						<th class="text-left">Year</th>
						<th class="text-left">Mileage</th>
						<th class="text-left">Selling Price</th>
						<th class="text-left">Lease Term (months)</th>
						<th class="text-left">Monthly Payment</th>
					</tr>
					</thead>
					<tbody class="table-hover">
					<tr>
						<td class="text-left">Mark</td>
						<td class="text-left">Ivensky</td>
						<td class="text-left">215-180-1204</td>
						<td class="text-left">mivensky@gmail.com</td>
						<td class="text-left">JYV149MTS6G2409804</td>
						<td class="text-left">Infiniti</td>
						<td class="text-left">QX60</td>
						<td class="text-left">2017</td>
						<td class="text-left">19,221</td>
						<td class="text-left">$26,044</td>
						<td class="text-left">24</td>
						<td class="text-left">$409</td>
					</tr>
					<tr>
						<td class="text-left">Gabriel</td>
						<td class="text-left">Tkach</td>
						<td class="text-left">267-410-1955</td>
						<td class="text-left">gabe.tkach@gmail.com</td>
						<td class="text-left">JTJYWRBZ6G2009198</td>
						<td class="text-left">BMW</td>
						<td class="text-left">320i</td>
						<td class="text-left">2017</td>
						<td class="text-left">16,277</td>
						<td class="text-left">$20,292</td>
						<td class="text-left">24</td>
						<td class="text-left">$318</td>
					</tr>
					<tr>
						<td class="text-left">Dylan</td>
						<td class="text-left">Band</td>
						<td class="text-left">610-491-5810</td>
						<td class="text-left">dylanband28@yahoo.com</td>
						<td class="text-left">SALWG2VF5GA642581</td>
						<td class="text-left">Lexus</td>
						<td class="text-left">RX350</td>
						<td class="text-left">2017</td>
						<td class="text-left">34,551</td>
						<td class="text-left">$30,748</td>
						<td class="text-left">36</td>
						<td class="text-left">$365</td>
					</tr>
					<tr>
						<td class="text-left">Zachary</td>
						<td class="text-left">Smith</td>
						<td class="text-left">215-195-1590</td>
						<td class="text-left">zachsmith011@gmail.com</td>
						<td class="text-left">YV126MEB3F1186381</td>
						<td class="text-left">BMW</td>
						<td class="text-left">X1 xDrive28i</td>
						<td class="text-left">2018</td>
						<td class="text-left">17,981</td>
						<td class="text-left">$25,377</td>
						<td class="text-left">24</td>
						<td class="text-left">$399</td>
					</tr>
					<tr>
						<td class="text-left">Moshe</td>
						<td class="text-left">Adika</td>
						<td class="text-left">610-589-9928</td>
						<td class="text-left">moshe.adika@verizon.net</td>
						<td class="text-left">YV1902TH6F2304610</td>
						<td class="text-left">Nissan</td>
						<td class="text-left">Altima 2.5 SL</td>
						<td class="text-left">2017</td>
						<td class="text-left">34,123</td>
						<td class="text-left">$15,282</td>
						<td class="text-left">24</td>
						<td class="text-left">$240</td>
					</tr>
					<tr>
						<td class="text-left">Vincent</td>
						<td class="text-left">Gonzales</td>
						<td class="text-left">212-491-4904</td>
						<td class="text-left">vgonzales@gmail.com</td>
						<td class="text-left">JA4JZ4AX9FZ001840</td>
						<td class="text-left">BMW</td>
						<td class="text-left">430i</td>
						<td class="text-left">2017</td>
						<td class="text-left">30,663</td>
						<td class="text-left">$23,517</td>
						<td class="text-left">36</td>
						<td class="text-left">$278</td>
					</tr>
					<tr>
						<td class="text-left">Inna</td>
						<td class="text-left">Ravich</td>
						<td class="text-left">215-914-0643</td>
						<td class="text-left">innaravich@yahoo.com</td>
						<td class="text-left">3VW2M1AJ5EM308034</td>
						<td class="text-left">Chevrolet</td>
						<td class="text-left">Colorado 4WD LT</td>
						<td class="text-left">2018</td>
						<td class="text-left">35,174</td>
						<td class="text-left">$23,825</td>
						<td class="text-left">24</td>
						<td class="text-left">$374</td>
					</tr>
					<tr>
						<td class="text-left">Zachary</td>
						<td class="text-left">Zaltsberg</td>
						<td class="text-left">215-510-2590</td>
						<td class="text-left">zzaltsberg@gmail.com</td>
						<td class="text-left">WMWZP3C56FT298666</td>
						<td class="text-left">Ford</td>
						<td class="text-left">F-150 XLT</td>
						<td class="text-left">2018</td>
						<td class="text-left">39,562</td>
						<td class="text-left">$27,833</td>
						<td class="text-left">24</td>
						<td class="text-left">$437</td>
					</tr>
					<tr>
						<td class="text-left">Bar</td>
						<td class="text-left">Halperin</td>
						<td class="text-left">212-058-9515</td>
						<td class="text-left">bar.halperin@gmail.com</td>
						<td class="text-left">KNAFZ4A81F5290432</td>
						<td class="text-left">Chevrolet</td>
						<td class="text-left">Equinox Premier</td>
						<td class="text-left">2019</td>
						<td class="text-left">14,444</td>
						<td class="text-left">$23,037</td>
						<td class="text-left">36</td>
						<td class="text-left">$273</td>
					</tr>
					<tr>
						<td class="text-left">Hannah</td>
						<td class="text-left">Assour</td>
						<td class="text-left">215-195-6985</td>
						<td class="text-left">hannah.assour@gmail.com</td>
						<td class="text-left">WA1CMCFE3FD080332</td>
						<td class="text-left">Jeep</td>
						<td class="text-left">Grand Cherokee</td>
						<td class="text-left">2019</td>
						<td class="text-left">27,049</td>
						<td class="text-left">$29,849</td>
						<td class="text-left">24</td>
						<td class="text-left">$469</td>
					</tr>
					</tbody>
					</table>
			</div>
		);
	}
}

export default History;