const EposTransactions = ({ data }) => (
  <tbody>
    <tr>
      <th scope="row">{data.timestamp}</th>
      <td>{data.amount}</td>
      <td>{data.vendor}</td>
      <td>{data.streetName}</td>
      <td>{data.postcode}</td>
    </tr>
  </tbody>
);

export default EposTransactions;
