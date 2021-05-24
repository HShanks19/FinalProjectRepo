const Household = ({ data }) => (
  <>
    <tr>
      <th scope="row">{data.personName}</th>
      <td>{data.dateOfBirth}</td>
      <button type="button">View Profile</button>
    </tr>
  </>
);

export default Household;
