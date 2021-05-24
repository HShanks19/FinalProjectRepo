const eposTransactions = ({ data }) => (
  <tbody>
    <tr>
      <th scope="row">{data.bankcardDTOs.eposTransactions.timestamp}</th>
      <td>{data.bankcardDTOs.eposTransactions.amount}</td>
      <td>{data.bankcardDTOs.eposTransactions.vendor}</td>
      <td>{data.bankcardDTOs.eposTransactions.streetName}</td>
      <td>{data.bankcardDTOs.eposTransactions.postcode}</td>
    </tr>
  </tbody>
);

export default eposTransactions;
