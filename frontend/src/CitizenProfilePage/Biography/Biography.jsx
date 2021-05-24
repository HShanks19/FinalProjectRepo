import './Biography.css';
import { useState, useEffect } from 'react';
import axios from 'axios';
import BiographyRender from './BiographyRender';

const Biography = () => {
  const [data, setData] = useState([]);
  const makeRequest = () => {
    axios.get('http://54.74.11.52:5001/getBiographicalInfo/4989925828')
      .then((response) => {
        setData(response.data);
        console.log(data);
      }).catch((err) => console.log(err));
  };
  useEffect(() => { makeRequest(); }, []);
  const RenderInformation = data.map((d) => <BiographyRender data={d} />);
  return (
    <>
      {RenderInformation}
    </>
  );
};

export default Biography;
