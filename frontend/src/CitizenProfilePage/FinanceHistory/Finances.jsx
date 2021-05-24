import axios from 'axios';
import { useState, componentDidMount } from 'react';
import FinancesRender from './FinancesRender';

const Finances = () => {
  const [data, setData] = useState([]);

  const makePostRequest = () => {
    axios.get('http://54.74.11.52:5001/getMatchingBankAccounts/')
      .then((response) => {
        setData(response.data);
        console.log(data);
      }).catch((err) => console.log(err));
  };
  componentDidMount(() => { makePostRequest(); }, [data]);
  const RenderFinancesInformation = data.map((d) => <FinancesRender data={d} />);
  return (
    <>
      {RenderFinancesInformation}
    </>
  );
};

export default Finances;
