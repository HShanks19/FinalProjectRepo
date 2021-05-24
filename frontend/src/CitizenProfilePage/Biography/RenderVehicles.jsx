const RenderVehicles = ({ data }) => (
  <>
    <h5 className="card-text">
      Vehicle:
    </h5>
    <h5 className="card-text">
      Registration Plate:
      {' '}
      {data.vehicleRegistrationNo}
    </h5>
    <h5 className="card-text">
      Make:
      {' '}
      {data.make}
    </h5>
    <h5 className="card-text">
      Model:
      {' '}
      {data.model}
    </h5>
    <h5 className="card-text">
      Colour:
      {' '}
      {data.colour}
    </h5>
  </>
);

export default RenderVehicles;
