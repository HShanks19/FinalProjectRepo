import PropTypes from 'prop-types';

const Biography = ({
  // eslint-disable-next-line max-len
  firstName, lastName, dateOfBirth, placeOfBirth, address, phoneNumber, vehicleRegistrationPlate, vehicleMake, vehicleModel, vehicleColour,
}) => (
  <div className="card">
    <div className="card-body">
      <h4 className="card-title">
        Citizen Name:
        {' '}
        {firstName + lastName}
      </h4>
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
);

export default Biography;

Biography.propTypes = {
  firstName: PropTypes.string.isRequired,
  lastName: PropTypes.string.isRequired,
  dateOfBirth: PropTypes.string.isRequired,
  placeOfBirth: PropTypes.string.isRequired,
  address: PropTypes.string.isRequired,
  phoneNumber: PropTypes.string.isRequired,
  vehicleRegistrationPlate: PropTypes.string.isRequired,
  vehicleMake: PropTypes.string.isRequired,
  vehicleModel: PropTypes.string.isRequired,
  vehicleColour: PropTypes.string.isRequired,
};
