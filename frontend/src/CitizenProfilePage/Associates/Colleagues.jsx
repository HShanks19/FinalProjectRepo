const Colleagues = ({ data }) => (

  <table className="table">
    <thead>
      <tr>
        <th scope="col">Time Stamp</th>
        <th scope="col">Receiver</th>
        <th scope="col">Receiver Phone Number</th>
        <th scope="col">View Receiver Bio</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th scope="row">{data.timeStamp}</th>
        <td>{data.receiver}</td>
        <td>{data.receiverPhoneNumber}</td>
        <button type="button">View Profile</button>
      </tr>
    </tbody>
  </table>
);

export default Colleagues;
