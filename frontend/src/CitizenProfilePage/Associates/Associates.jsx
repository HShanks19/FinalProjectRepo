import { componentDidMount, useState } from 'react';
import axios from 'axios';
import AssociatesRender from './AssociatesRender';

const Associates = () => {
  const [data, setData] = useState([]);
  const makeRequest = () => {
    axios.post('http://54.74.11.52:5001/getCitizensAssociates/')
      .then((response) => {
        setData(response.data);
        console.log(data);
      }).catch((err) => console.log(err));
  };
  componentDidMount(() => { makeRequest(); }, [data]);
  const RenderAssociatesInformation = data.map((d) => <AssociatesRender data={d} />);

  return (
    <>
      {RenderAssociatesInformation}
    </>
  );
};

export default Associates;
