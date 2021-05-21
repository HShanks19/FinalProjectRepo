import axios from 'axios';
import { useState } from 'react';

const Finances = ({
  // eslint-disable-next-line max-len
  bank, sortCode, accountNumber, eposTimeStamp, eposAmount, eposAccountNumber, vendor, eposAddress, atmTimeStamps, atmAmount, operator, streetName, postCode,
}) => {
  const [financialHistory, setFinancialHistory] = useState([]);

  function findFinancialHistory() {
    axios.post('http://54.74.6.120:5001/getMatchingBankAccounts/')
      .then((response) => {
        setFinancialHistory(response.data);
      })
      .catch((err) => console.log(err));
  }
  return (
    <>
      <Finances
        findFinancialHistory={findFinancialHistory}
        financialHistory={financialHistory}
      />
      <container>
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
      </container>
    </>
  );
};

export default Finances;
