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
        <button type="button" onClick="handleClick">View</button>
      </tr>
    </thead>
    <tbody />
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
