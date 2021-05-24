import axios from 'axios';
<<<<<<< HEAD
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
=======
  const RenderFinancesInformation = financialHistory.map((d) => <FinancesRender data={d} />);
  return (
    <>
      {RenderFinancesInformation}
>>>>>>> 162b9b4031c750e74c6d6e65cb587320b08c7f20
    </>
  );
};

export default Finances;
