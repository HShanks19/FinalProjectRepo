const Colleagues = ({ data }) => (
  <tbody>
    <tr>
      <th scope="row">{data.personName}</th>
      <td>{data.dateOfBirth}</td>
      <button type="button">View Profile</button>
    </tr>
  </tbody>
);

export default Colleagues;
