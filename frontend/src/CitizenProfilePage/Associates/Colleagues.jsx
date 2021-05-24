const Colleagues = ({ data }) => (
  <tbody>
    <tr>
      <th scope="row">{data.colleagues.personName}</th>
      <td>{data.colleagues.dateOfBirth}</td>
      <button type="button">View Profile</button>
    </tr>
  </tbody>
);

export default Colleagues;
