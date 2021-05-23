import { useEffect, useState } from 'react';
import axios from 'axios';
import './Biography.css';

const Biography = ({
  // eslint-disable-next-line max-len
  forenames, surname, dateOfBirth, placeOfBirth, address, phoneNumber, vehicleRegistrationPlate, vehicleMake, vehicleModel, vehicleColour,
}) => {
  const [citizenBioData, setCitizenBioData] = useState([]);
  const [fetchData, setFetch] = useState(false);

  useEffect(() => {
    if (fetchData) {
      axios.get('http://52.211.82.10:5001/getBiographicalInfo/1118865837')
        .then((res) => setCitizenBioData(res.data));
    }
  }, [fetchData]);

  return (
    <>
      <container>
        <Biography
          citizenBioData={citizenBioData}
          setFetch={setFetch(true)}
        />
        <div className="card-container">
          <h4 className="card-title">
            Citizen Name:
            {' '}
            {forenames}
            {' '}
            {surname}
          </h4>
          <div className="card-body">
            <h5 className="card-text">
              Date of Birth:
              {' '}
              {dateOfBirth}
            </h5>
            <h5 className="card-text">
              Place of Birth:
              {' '}
              {placeOfBirth}
            </h5>
            <h5 className="card-text">
              Address:
              {' '}
              {address}
            </h5>
            <h5 className="card-text">
              Phone Number:
              {' '}
              {phoneNumber}
            </h5>
            <br />
            <h5 className="card-text">
              Vehicle:
            </h5>
            <h5 className="card-text">
              Registration Plate:
              {' '}
              {vehicleRegistrationPlate}
            </h5>
            <h5 className="card-text">
              Make:
              {' '}
              {vehicleMake}
            </h5>
            <h5 className="card-text">
              Model:
              {' '}
              {vehicleModel}
            </h5>
            <h5 className="card-text">
              Colour:
              {' '}
              {vehicleColour}
            </h5>
          </div>
        </div>
      </container>
    </>
  );
};

export default Biography;
