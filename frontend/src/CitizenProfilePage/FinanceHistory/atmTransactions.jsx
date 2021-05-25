const AtmTransactions = ({ data }) => (
  <tbody>
    <tr>
      <th scope="row">{data.timestamp}</th>
      <td>{data.amount}</td>
      <td>{data.operator}</td>
      <td>{data.streetName}</td>
      <td>{data.postcode}</td>
    </tr>
  </tbody>
);

export default AtmTransactions;
