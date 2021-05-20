import { useState } from 'react';
import axios from 'axios';

const Associates = ({
  receiver, receiverPhoneNumber, timeStamp, firstName, lastName, dateOfBirth, placeOfBirth, address,
}) => {
  const [associatesRelated, setAssociatesRelated] = useState([]);

  function findAssociates() {
    axios.post('http://54.74.6.120:5001/getCitizensAssociates/')
      .then((response) => {
        setAssociatesRelated(response.data);
      })
      .catch((err) => console.log(err));
  }
  return (
    <>
      {findAssociates}
      {associatesRelated}

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
            <th scope="row">{timeStamp}</th>
            <td>{receiver}</td>
            <td>{receiverPhoneNumber}</td>
            <button type="button" onClick="handleClick">View</button>
          </tr>
        </tbody>
      </table>
      ;

      <div className="modal" tabIndex="-1">
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Receiver</h5>
            </div>
            <div className="modal-body">
              <h4>
                Citizen Name:
                {' '}
                {firstName + lastName}
              </h4>
              <h5>
                Date of Birth:
                {' '}
                {dateOfBirth}
              </h5>
              <h5>
                Place of Birth:
                {' '}
                {placeOfBirth}
              </h5>
              <h5>
                Address:
                {' '}
                {address}
              </h5>
            </div>
            <div className="modal-footer">
              <button type="button" className="btn-close" data-bs-dismiss="modal" variant="outline-danger" size="lg" aria-label="Close">Close</button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Associates;
