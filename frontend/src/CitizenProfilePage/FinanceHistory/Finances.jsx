import axios from 'axios';
import { useState, useEffect } from 'react';
import FinancesRender from './FinancesRender';

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
        console.log(financialHistory);
      })
      .catch((err) => console.log(err));
  }

  useEffect(() => { findFinancialHistory(); }, []);

  const RenderFinancesInformation = financialHistory.map((d) => <FinancesRender data={d} />);
  return (
    <>
      {RenderFinancesInformation}
    </>
  );
};

export default Finances;
