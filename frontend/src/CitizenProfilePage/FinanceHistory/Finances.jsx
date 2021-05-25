import axios from 'axios';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import FinancesRender from './FinancesRender';

const Finances = () => {
  const [financialHistory, setFinancialHistory] = useState([]);
  const { citizenId } = useParams();
  console.log('citizenId ', citizenId);
  const makeRequest = () => {
    axios.get(`http://54.74.11.52:5001/getBiographicalInfo/${citizenId}`)
      .then((response) => {
        console.log(response.data);
        axios.post('http://54.74.11.52:5001/getMatchingBankAccounts/', { forenames: `${response.data[0].forenames}`, surname: `${response.data[0].surname}`, dateOfBirth: `${response.data[0].dateOfBirth}` })
          .then((res) => {
            setFinancialHistory(res.data);
            console.log(financialHistory);
          })
          .catch((err) => console.log(err));
      }).catch((err) => console.log(err));
  };
  useEffect(() => { makeRequest(); }, []);

  const RenderFinancesInformation = financialHistory.map((d) => <FinancesRender data={d} />);
  return (
    <>
      {RenderFinancesInformation}
    </>
  );
};

export default Finances;
