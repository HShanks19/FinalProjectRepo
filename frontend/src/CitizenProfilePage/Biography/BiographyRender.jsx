import RenderPhone from './RenderPhone';
import RenderVehicle from './RenderVehicles';

const BiographyRender = ({ data }) => {
  const Vehicles = data.citizensVehicles;
  const Phones = data.citizensMobileNumbers;
  const VehicleInfo = Vehicles.map((d) => <RenderVehicle data={d} />);
  const PhoneInfo = Phones.map((d) => <RenderPhone data={d} />);
  return (
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
        </div>
        {PhoneInfo}
        {VehicleInfo}
      </div>
    </>
  );
};

export default BiographyRender;
