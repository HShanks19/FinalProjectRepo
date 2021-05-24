const CallRecords = ({ data }) => (
  <>
    <tbody>
      <tr>
        <th scope="row">{data.callRecords.mobileCallRecords.timeStamp}</th>
        <td>{data.callRecords.mobileCallRecords.receiver}</td>
        <td>{data.callRecords.mobileCallRecords.receiverPhoneNumber}</td>
        <button type="button">View Profile</button>
      </tr>
    </tbody>

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
