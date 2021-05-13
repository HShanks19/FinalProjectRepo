import PropTypes from 'prop-types';

const Associates = ({
  receiver, receiverPhoneNumber, timeStamp, firstName, lastName, dateOfBirth, placeOfBirth, address,
}) => {
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
  </table>;

  return (
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
  );
};

export default Associates;

Associates.propTypes = {
  firstName: PropTypes.string.isRequired,
  lastName: PropTypes.string.isRequired,
  dateOfBirth: PropTypes.string.isRequired,
  placeOfBirth: PropTypes.string.isRequired,
  address: PropTypes.string.isRequired,
  timeStamp: PropTypes.string.isRequired,
  receiver: PropTypes.string.isRequired,
  receiverPhoneNumber: PropTypes.string.isRequired,
};
