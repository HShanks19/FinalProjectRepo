const BiographyRender = ({ data }) => (
  <>
    <div className="card-container">
      <h4 className="card-title">
        Citizen Name:
        {' '}
        {data.forenames}
        {' '}
        {data.surname}
      </h4>
      <div className="card-body">
        <h5 className="card-text">
          Date of Birth:
          {' '}
          {data.dateOfBirth}
        </h5>
        <h5 className="card-text">
          Place of Birth:
          {' '}
          {data.placeOfBirth}
        </h5>
        <h5 className="card-text">
          Address:
          {' '}
          {data.homeAddress}
        </h5>
        <h5 className="card-text">
          Phone Number:
          {' '}
          {data.citizensMobileNumbers[0].phoneNumber}
        </h5>
        <h5 className="card-text">
          Vehicle:
        </h5>
        <h5 className="card-text">
          Registration Plate:
          {' '}
          {data.citizensVehicles[0].vehicleRegistrationNo}
        </h5>
        <h5 className="card-text">
          Make:
          {' '}
          {data.citizensVehicles[0].make}
        </h5>
        <h5 className="card-text">
          Model:
          {' '}
          {data.citizensVehicles[0].model}
        </h5>
        <h5 className="card-text">
          Colour:
          {' '}
          {data.citizensVehicles[0].colour}
        </h5>
      </div>
    </div>
  </>
);

export default BiographyRender;
