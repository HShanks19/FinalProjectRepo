const CallRecords = ({ data }) => (
  <>
    <tr>
      <th scope="row">{data.timestamp}</th>
      <td>{data.receiverName}</td>
      <td>{data.receiverMSISDN}</td>
      <button type="button">View Profile</button>
    </tr>

    <div>
      <div className="modal" tabIndex="-1">
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Receiver Biography</h5>
            </div>
            <div className="modal-body">
              <h4>
                Citizen Name:
                {' '}
                {data.forenames}
                {' '}
                {data.surname}
              </h4>
              <h5>
                Date of Birth:
                {' '}
                {data.dateOfBirth}
              </h5>
              <h5>
                Place of Birth:
                {' '}
                {data.placeOfBirth}
              </h5>
              <h5>
                Address:
                {' '}
                {data.address}
              </h5>
            </div>
            <div className="modal-footer">
              <button type="button" className="btn-close" data-bs-dismiss="modal" variant="outline-danger" size="lg" aria-label="Close">Close</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </>
);

export default CallRecords;
