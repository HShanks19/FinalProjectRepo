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
          {data.address}
        </h5>
        <h5 className="card-text">
          Phone Number:
          {' '}
          {data.phoneNumber}
        </h5>
        <h5 className="card-text">
          Vehicle:
        </h5>
        <h5 className="card-text">
          Registration Plate:
          {' '}
          {data.vehicleRegistrationPlate}
        </h5>
        <h5 className="card-text">
          Make:
          {' '}
          {data.vehicleMake}
        </h5>
        <h5 className="card-text">
          Model:
          {' '}
          {data.vehicleModel}
        </h5>
        <h5 className="card-text">
          Colour:
          {' '}
          {data.vehicleColour}
        </h5>
      </div>
    </div>
  </>
);

export default BiographyRender;
