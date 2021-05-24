import { useEffect, useState } from 'react';
import axios from 'axios';
import Biography from '../Biography/Biography';

const Associates = ({
  // eslint-disable-next-line max-len
  receiver, receiverPhoneNumber, timeStamp, forenames, surname, dateOfBirth, placeOfBirth, address,
}) => {
  const [associatesRelated, setAssociatesRelated] = useState([]);
  const [citizenBioData, setCitizenBioData] = useState([]);
  const [fetchData, setFetch] = useState(false);

  useEffect(() => {
    if (fetchData) {
      axios.post('http://52.211.82.10:5001/getCitizensAssociates/')
        .then((res) => setAssociatesRelated(res.data));
      console.log(associatesRelated);
    }
  }, [fetchData]);

  useEffect(() => {
    if (fetchData) {
      axios.get('http://52.211.82.10:5001/getBiographicalInfo/1118865837')
        .then((res) => setCitizenBioData(res.data));
      console.log(citizenBioData);
    }
  }, [fetchData]);

  return (
    <>
      <Associates
        associatesRelated={associatesRelated}
      />

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
            <button type="button" onClick={setFetch(true)}>View Profile</button>
          </tr>
        </tbody>
      </table>
      <div>
        <Biography
          citizenBioData={citizenBioData}
        />
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
                  {forenames}
                  {' '}
                  {surname}
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
      </div>
    </>
  );
};

export default Associates;
