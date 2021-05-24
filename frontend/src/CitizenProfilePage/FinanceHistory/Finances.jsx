import axios from 'axios';
import { useState, useEffect } from 'react';
import eposTransactions from './eposTransactions';
import atmTransactions from './atmTransactions';

const Finances = () => {
  const [financialHistory, setFinancialHistory] = useState([]);

  const postObject = {
    forenames: 'Julie',
    surname: 'Willis',
    homeAddress: '4 THISTLECROFT ROAD, WALTON-ON-THAMES, KT12 5QZ',
  };

  function findFinancialHistory() {
    axios.post('http://52.211.82.10:5001/getMatchingBankAccounts/', postObject)
      .then((response) => {
        setFinancialHistory(response.data);
      })
      .catch((err) => console.log(err));
  }

  useEffect(() => { findFinancialHistory(); }, [financialHistory]);

  const RenderATMInformation = financialHistory.map((d) => <atmTransactions data={d} />);

  const RenderEPOSInformation = financialHistory.map((d) => <eposTransactions data={d} />);
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
          {financialHistory.bank}
          sortCode:
          {' '}
          {financialHistory.bankcardDTOs.sortCode}
          accountNumber:
          {' '}
          {financialHistory.accountNumber}
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
          { RenderEPOSInformation }
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
          { RenderATMInformation }
        </table>
      </container>
    </>
  );
};

export default Finances;
