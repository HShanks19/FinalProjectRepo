import PropTypes from 'prop-types';

const Finances = ({
  // eslint-disable-next-line max-len
  bank, sortCode, accountNumber, eposTimeStamp, eposAmount, eposAccountNumber, vendor, eposAddress, atmTimeStamps, atmAmount, operator, streetName, postCode,
}) => {
  <>
    <div>
      Bank:
      {' '}
      {bank}
      sortCode:
      {' '}
      {sortCode}
      accountNumber:
      {' '}
      {accountNumber}
    </div>
    <table className="table" id="eposTable">
      <thead>
        <tr>
          <th scope="col">Time Stamp</th>
          <th scope="col">Amount</th>
          <th scope="col">Account</th>
          <th scope="col">Vendor</th>
          <th scope="col">Address</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">{eposTimeStamp}</th>
          <td>{eposAmount}</td>
          <td>{eposAccountNumber}</td>
          <td>{vendor}</td>
          <td>{eposAddress}</td>
        </tr>
      </tbody>
    </table>
    <table className="table" id="atmTable">
      <thead>
        <tr>
          <th scope="col">Time Stamp</th>
          <th scope="col">Amount</th>
          <th scope="col">Operator</th>
          <th scope="col">Street Name</th>
          <th scope="col">Post Code</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">{atmTimeStamps}</th>
          <td>{atmAmount}</td>
          <td>{operator}</td>
          <td>{streetName}</td>
          <td>{postCode}</td>
        </tr>
      </tbody>
    </table>
  </>;
};

export default Finances;

Finances.propTypes = {
  bank: PropTypes.string.isRequired,
  sortCode: PropTypes.string.isRequired,
  accountNumber: PropTypes.string.isRequired,
  eposTimeStamp: PropTypes.string.isRequired,
  eposAmount: PropTypes.string.isRequired,
  eposAccountNumber: PropTypes.string.isRequired,
  vendor: PropTypes.string.isRequired,
  eposAddress: PropTypes.string.isRequired,
  atmTimeStamps: PropTypes.string.isRequired,
  atmAmount: PropTypes.string.isRequired,
  operator: PropTypes.string.isRequired,
  streetName: PropTypes.string.isRequired,
  postCode: PropTypes.string.isRequired,
};
