const Business = ({ data }) => (
  <div>
    Business Name:
    {' '}
    {data.businessName}
    <br />
    Business Address:
    {' '}
    {data.businessAddress}
  </div>
);

export default Business;
