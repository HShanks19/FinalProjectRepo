const atmTransactions = ({ data }) => (
  <tbody>
    <tr>
      <th scope="row">{data.bankcardDTOs.atmTransactions.timestamp}</th>
      <td>{data.bankcardDTOs.atmTransactions.amount}</td>
      <td>{data.bankcardDTOs.atmTransactions.operator}</td>
      <td>{data.bankcardDTOs.atmTransactions.streetName}</td>
      <td>{data.bankcardDTOs.atmTransactions.postcode}</td>
    </tr>
  </tbody>
);

export default atmTransactions;
